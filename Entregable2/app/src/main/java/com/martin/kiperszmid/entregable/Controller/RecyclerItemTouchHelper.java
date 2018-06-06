package com.martin.kiperszmid.entregable.Controller;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback{

    private NotificadorRITH notificadorRITH;

    public RecyclerItemTouchHelper(int dragDirs, int swipeDirs, NotificadorRITH notificadorRITH) {
        super(dragDirs, swipeDirs);
        this.notificadorRITH = notificadorRITH;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if(viewHolder != null){
            View foreground = ((RecyclerAdapter.CeldaViewHolder) viewHolder).viewForeground;
            getDefaultUIUtil().onSelected(foreground);
        }
    }

    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View foreground = ((RecyclerAdapter.CeldaViewHolder) viewHolder).viewForeground;
        getDefaultUIUtil().onDrawOver(c, recyclerView, foreground, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        View foreground = ((RecyclerAdapter.CeldaViewHolder) viewHolder).viewForeground;
        getDefaultUIUtil().clearView(foreground);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View foreground = ((RecyclerAdapter.CeldaViewHolder) viewHolder).viewForeground;
        getDefaultUIUtil().onDraw(c, recyclerView, foreground, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //return notificadorRITH.onMove(recyclerView, viewHolder, target);
        return true;
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        notificadorRITH.onSwiped(viewHolder, direction, viewHolder.getAdapterPosition());
    }
    public interface NotificadorRITH {
        void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
    }
}
