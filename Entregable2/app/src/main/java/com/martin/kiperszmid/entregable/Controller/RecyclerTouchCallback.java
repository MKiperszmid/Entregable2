package com.martin.kiperszmid.entregable.Controller;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

public class RecyclerTouchCallback extends ItemTouchHelper.Callback {

    private RecyclerAdapter adapter;

    private OnStartDragListener startDragListener;

    public RecyclerTouchCallback(RecyclerAdapter adapter, OnStartDragListener startDragListener){
        this.adapter = adapter;
        this.startDragListener = startDragListener;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        adapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        startDragListener.onSwiped(viewHolder, direction);
    }

    public interface OnStartDragListener{
        public void onStartDrag(RecyclerView.ViewHolder viewHolder);
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction);
    }

    public interface ItemTouchHelperViewHolder{
        public void onItemSelected();
        public void onItemClear();
    }

    public interface ItemTouchHelperAdapter {
        public boolean onItemMove(int startPos, int endPos);
        public void onItemDismiss(int position);
    }
}
