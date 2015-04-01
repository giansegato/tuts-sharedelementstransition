package com.tutsplus.code.sharedelementtransition;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DataManager extends RecyclerView.Adapter<DataManager.RecyclerViewHolder> {

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView mName, mPhone;
        View mCircle;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.CONTACT_name);
            mPhone = (TextView) itemView.findViewById(R.id.CONTACT_phone);
            mCircle = itemView.findViewById(R.id.CONTACT_circle);
        }
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_item, viewGroup, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {
        // get the single element from the main array
        final Contact contact = Contact.CONTACTS[i];
        // Set the values
        viewHolder.mName.setText(contact.get(Contact.Field.NAME));
        viewHolder.mPhone.setText(contact.get(Contact.Field.PHONE));
        // Set the color of the shape
        GradientDrawable bgShape = (GradientDrawable) viewHolder.mCircle.getBackground();
        bgShape.setColor(Color.parseColor(contact.get(Contact.Field.COLOR)));
    }

    @Override
    public int getItemCount() {
        return Contact.CONTACTS.length;
    }
}