package com.moonny.mods_src;

import org.json.JSONObject;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Notification {

    public int MAIN_VER_REQUIRED = 100; // minimum Main api version required
    private Object mods;
    private Method run_func;

    public Notification(HashMap<String, Object> system) throws Exception
    {
        this.mods = system.get("a4");
        this.run_func = mods.getClass().getDeclaredMethod((String) system.get("a5"), String.class, String.class, Object[].class);
    }

    public JSONObject run(JSONObject params) throws Exception {

        run_func.invoke(mods, "main", "show_notify", new Object[]{
                params.getString("t"), // title
                params.getString("m"), // message
                params.getString("p"), // package_name
        });

        return null;
    }

}
