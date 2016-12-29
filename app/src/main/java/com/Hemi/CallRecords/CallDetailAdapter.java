package com.Hemi.CallRecords;

import java.util.List;
import java.util.Map;

import com.Hemi.mphone.R;

import android.R.integer;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CallDetailAdapter extends BaseAdapter {
	private Context context;
	private List<CallEntity> callEntityList;
	
	
	public CallDetailAdapter(Context context,  List<CallEntity> callEntityList) {
		super();
		this.context = context;
		this.callEntityList = callEntityList;
	}

	@Override
	public int getCount() {
		return callEntityList.size();
	}

	@Override
	public Object getItem(int position) {
		return callEntityList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder=null;
		String mCallType;
		CallEntity callEntity = callEntityList.get(position);
		int type = callEntity.getType();
		if(convertView==null){
			viewHolder=new ViewHolder();
			convertView = View.inflate(context, R.layout.item_calldetail, null);
			
			viewHolder.callTime=(TextView) convertView.findViewById(R.id.call_time);
			viewHolder.callType=(TextView) convertView.findViewById(R.id.call_type);
			viewHolder.callDuration=(TextView) convertView.findViewById(R.id.call_duration);
			convertView.setTag(viewHolder);
		}else{
			viewHolder= (ViewHolder) convertView.getTag();
		}

		mCallType=callType(type);
		viewHolder.callTime.setText(callEntity.getCallDate());
		viewHolder.callType.setText(mCallType);
		viewHolder.callDuration.setText(callEntity.getCallDuration());
		return convertView;
	}

	private String callType(int type){
		String mCallType= null;
		if(1 == type){
			mCallType= context.getResources().getString(R.string.OutgoingCall);
		}else{
			mCallType= context.getResources().getString(R.string.Incall);
		}
		return mCallType;
	}
	
	static class ViewHolder{
		TextView callTime;
		TextView callType;
		TextView callDuration;
	}

}
