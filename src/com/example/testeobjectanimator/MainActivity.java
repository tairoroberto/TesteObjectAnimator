package com.example.testeobjectanimator;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
	private ImageView imageView;
	private boolean flag = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView)findViewById(R.id.imageView1);
	}
	
	
	public void  efeitoXml(View view) {
		//cria o ObjectAnimator
		ObjectAnimator animacao = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.animacao);
		animacao.setTarget(imageView);
		
		//verifica se flag é true, se for true ele inicia a animação 
		//senão ele reverte a animação.
		if (flag) {
			animacao.start();
		}else{
			animacao.reverse();	
		}
		flag = !flag;
	}
	
	public void efeitoApi(View view) {
		//cria o ObjectAnimator 1 para o efeito de fadeIn
		PropertyValuesHolder annimacao1 = PropertyValuesHolder.ofFloat("alpha", 1f,0f);
		
		//cria o ObjectAnimator 1 para o efeito de movimento
		PropertyValuesHolder annimacao2 = PropertyValuesHolder.ofFloat("x", 0f,30f);
		
		//cria o ObjectAnimator 1 para o efeito de movimento
		PropertyValuesHolder annimacao3 = PropertyValuesHolder.ofFloat("y", 0f,30f);
		
		//cria o ObjectAnimator 2 para o efeito de fade
		ObjectAnimator animacao = ObjectAnimator.ofPropertyValuesHolder(imageView, annimacao1,annimacao2,annimacao3);
		animacao.setDuration(3000);
		animacao.setRepeatCount(2);
		animacao.setRepeatMode(ObjectAnimator.INFINITE);
		
		//Adiciona um listener para verificar as acoes da animacao.
		animacao.addListener(new AnimatorListener() {
			
			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub
				Log.i("Script", "Iniciou Animação");
				
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub
				Log.i("Script", "Repetindo Animação");
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				// TODO Auto-generated method stub
				Log.i("Script", "Finalizou Animação");
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				// TODO Auto-generated method stub
				Log.i("Script", "Cancelou Animação");
			}
		});
		
		
		//verifica se flag é true, se for true ele inicia a animação 
		//senão ele reverte a animação.
		if (flag) {
			animacao.start();
		}else{
			animacao.reverse();	
		}
		flag = !flag;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
