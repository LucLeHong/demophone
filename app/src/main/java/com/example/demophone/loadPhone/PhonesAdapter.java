package com.example.demophone.loadPhone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demophone.R;

import java.util.List;

public class PhonesAdapter extends BaseAdapter {
    List<Phones> lstPhones;

    public PhonesAdapter(List<Phones> lstPhones) {
        this.lstPhones = lstPhones;
    }

    @Override
    public int getCount() {
        return lstPhones.size() ;
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
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHoder hoder;
        if (convertView == null) {
            hoder = new ViewHoder();
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_phone, null);
            hoder.txtName =  convertView.findViewById(R.id.txt_name);
            hoder.txtPhone =  convertView.findViewById(R.id.txt_phone);
            convertView.setTag(hoder);
        } else {
            hoder = (ViewHoder) convertView.getTag();
        }
        Phones phones=lstPhones.get(i);
        hoder.txtName.setText(phones.getName());
        hoder.txtPhone.setText(phones.getPhone());
        return convertView;
    }

    private class ViewHoder {
        TextView txtName, txtPhone;
    }
}
