package psst.permadi.dstcashier.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import psst.permadi.dstcashier.R;

public class CustomAndroidGridViewAdapter2 extends BaseAdapter {
    private Context mContext;
    LayoutInflater inflter;
    private final String[] gridViewString;
    private final String[] ImageId;

    public CustomAndroidGridViewAdapter2(Context context, String[] gridViewString, String[] ImageId) {
        mContext = context;
        this.ImageId = ImageId;
        this.gridViewString = gridViewString;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return gridViewString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.layout_maintrx, null);
        TextView gridtrx = (TextView) view.findViewById(R.id.txtTitle);
        TextView gridTgl = (TextView) view.findViewById(R.id.txtTanggal);
        gridtrx.setText(gridViewString[i]);
        gridTgl.setText(ImageId[i]);
        return view;
    }
}
