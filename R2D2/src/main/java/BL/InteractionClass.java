package BL;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.app.IntentService;
import com.iot_pilot.assistant.r2d2.SL.ServiceClass;

/**
 * Created by tejasad on 11/11/2014.
 */
public class InteractionClass {

    private Context passedContext;
    public InteractionClass(Context context)
    {

            //Start the Service class instance
        try{
            passedContext = context;
            Intent intent = new Intent(context, ServiceClass.class);
            passedContext.startService(intent);


        }
         catch(Exception expc)
         {


         }





    }



}
