package com.martin.kiperszmid.entregable.Model.DAO;

import com.martin.kiperszmid.entregable.Model.POJO.Receta;
import com.martin.kiperszmid.entregable.R;

import java.util.ArrayList;
import java.util.List;

public class RecetaDao {

    public static List<Receta> getListaRecetas(){
        List<Receta> recetas = new ArrayList<>();

        recetas.add(new Receta("Pollo asado con ciruelas", "1 sobre de Jugoso al Horno Tradicional Pollo Asado MAGGI, 8 muslos de pollo, 8 orejones, 8 ciruelas pasas, 1 palito de canela en rama",
                "Calentar el horno a 200 ºC y retirar la bandeja del horno.\n" +
                "Colocar todos los ingredientes dentro de la bolsa, tal como se indica en las instrucciones, cerrarlo bien con la brida y cocerlo en el horno durante 1 hora, tal como se indica en las instrucciones.\n" +
                "Podemos añadir 100 ml (1/2 vaso) de agua o vino blanco para su cocción.\n" +
                "Sacarlo, dejarlo reposar unos minutos para no quemarse y con ayuda de unas tijeras, cortar la bolsa y servirlo en una fuente para servir.", R.drawable.dom));

        recetas.add(new Receta("Crema de calabaza y patata", "1/2 bolsa de Puré de patatas MAGGI, 500 g de pulpa de calabaza, 1 puerro, 2 cucharadas de aceite de oliva, sal",
                "Cortar la pulpa de calabaza en trozos pequeños. Limpiar el puerro y cortarlo en trocitos.\n" +
                "Rehogarlo en un cazo con un poco de aceite durante unos minutos. Cubrirlo con ¾ de agua y llevarlo a ebullición y cocerlo unos 15 minutos. Sazonar con un poco de sal.\n" +
                "Triturarlo y espolvorear los copos de puré de patatas y mezclarlo bien hasta que quede un puré.", R.drawable.tegui));

        recetas.add(new Receta("Merluza con brocoli", "1 sobre de Jugoso al Horno Tradicional Pollo Asado MAGGI, 500 g (4 lomos) de merluza congelada, 400 g de brócoli en ramitas, 200 g de cebolla cortada en láminas gruesas, 100 ml (1/2 vaso) de agua",
                "Calentar el horno a 200 ºC y retirar la bandeja del horno.\n" +
                        "Introducir los lomos de merluza en la bolsa especial para horno y espolvorear el contenido del sobre por encima. \n" +
                        "Agregar la cebolla, el brócoli y el agua.\n" +
                        "Cerrar la bolsa con el cierre especial y removerlo con cuidado removiendo bien los ingredientes. Colocar la bolsa sobre la bandeja de horno fría. Hacer unos pequeños cortes en la parte superior de la bolsa para facilitar la salida del vapor.\n" +
                        "Colocar la bandeja en la parte inferior del horno  y cocer el pollo durante 40 minutos.", R.drawable.borago));

        recetas.add(new Receta("Sopa de verduras con albondigas vegetarianas", "1 barqueta de Albóndigas vegetarianas GARDEN GOURMET, 800 g de verduras variadas: zanahorias, judías verdes, puerros, patatas, acelgas, pastilla de Caldo de Verduras MAGGI",
                "Cortar todas las verduras en trocitos y cocerlas en 1 l de agua con la pastilla de caldo desmenuzada hasta que estén tiernas, unos 20 minutos aproximadamente.\n" +
                        "Añadir las albóndigas a la sopa unos 10 minutos antes de finalizar la cocción.", R.drawable.maido));

        recetas.add(new Receta("Sopa de pollo oriental con bolitas picantes", "2 pechugas de pollo, 2 sobres de Pasta oriental pollo MAGGI, 800 ml (4 vasos) de agua, 1 calabacín, Jugo MAGGI",
                "Picar la pechuga de pollo con cualquier aparato junto con los chiles, el jengibre, el cilantro y el ajo y formar unas bolitas pequeñas; dejar reposar la mezcla en la nevera.\n" +
                        "Cortar el calabacín en tiritas finas.\n" +
                        "Cocer los fideos con el agua indicada y el sazonador y cuando empiece a hervir, añadir las albóndigas de pollo y el calabacín y dejarlo cocer unos 5 minutos a fuego suave.\n" +
                        "Servirlo con unas gotas de jugo Maggi.\n" +
                        "Las albóndigas de pollo le dan un toque especiado muy oriental.", R.drawable.quintonil));

        recetas.add(new Receta("Hojaldres de queso y pesto", "1 Masa de Hojaldre rectangular BUITONI, 1 tarrina de Pesto Genovese BUITONI, 100 g de queso Parmesano rallado",
                "Extender la lámina de hojaldre, pintarla con una capa fina de Pesto Genovese y espolvorearla con abundante queso rallado. Doblar los dos extremos e ir enrollando la masa por los dos lados hasta el centro de la misma. Aplastarla ligeramente con el rodillo y cortarla en tiras de aproximadamente 1 cm.\n" +
                        "Colocar las palmeras en una bandeja de horno dejando un poco de espacio entre ellas, ya que al subir el hojaldre aumentan de tamaño. Cocerlas en el horno, previamente calentado a 220ºC, durante unos 10 minutos (hasta que estén doradas), darles la vuelta y cocerlas 2 minutos más.\n" +
                        "Una idea para picar muy original y deliciosa. ", R.drawable.mani));
        recetas.add(new Receta("Pollo a la campesina con limón", "1 pollo cortado en octavos y sin piel, 4 cucharadas de Tomate Frito SOLÍS con aceite de oliva, 1 limón, 1 sobre de Jugoso al Horno selección de hierbas provenzales MAGGI",
                "Calentar el horno a 200ºC.\n" +
                        "Introducir el pollo en la bolsa especial para el horno (ojo! Tener cuidado de no perder el cierre al desplegarla). Espolvorear el contenido del sobre por el pollo. Agregar la salsa de tomate y el limón cortado en cuartos. Cerrar la bolsa con el cierre y removerla con cuidado repartiendo bien el condimento.\n" +
                        "Colocar la bolsa sobre una bandeja de horno y cocerlo durante 1 hora. Abrir la bolsa con cuidado y servirlo.", R.drawable.central));
        recetas.add(new Receta("Empanada de queso y membrillo", "1 Masa para Empanada BUITONI, 1/4 de membrillo, 1/4 de queso fresco tipo Burgos, 1 huevo",
                "Calentar el horno a 200ºC.\n" +
                        "Extender una masa de empanada y repartir sobre la mitad de la superficie, el membrillo y el queso por encima. Doblar la masa y cerrar bien los bordes presionando ligeramente con un tenedor y pintarla con el huevo batido. Practicar un agujero de un cm. en el centro, para permitir la salida de vapor.\n" +
                        "Cocerla en el horno, durante aproximadamente unos 20 minutos, hasta que esté dorada. Dejarla enfriar o servirla tibia.", R.drawable.astridygaston));
        return recetas;
    }
}
