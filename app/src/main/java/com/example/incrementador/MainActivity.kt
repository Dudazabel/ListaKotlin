package com.example.incrementador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.incrementador.ui.theme.IncrementadorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncrementadorTheme {
                Desafio(modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding())
            }
        }
    }
}

@Composable
fun Um(modifier: Modifier = Modifier){

    var valor by remember { mutableStateOf(0) }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = valor.toString())

        Spacer(Modifier.height(20.dp))

        Button(onClick = { valor++ }) {
            Text(text = "Incrementar")
        }
    }
}

@Composable
fun Dois(modifier: Modifier = Modifier){

    var valor by remember { mutableStateOf(0) }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = valor.toString())

        Spacer(Modifier.height(20.dp))

        Button(onClick = { valor++ }) {
            Text(text = "Incrementar")
        }

        Spacer(Modifier.height(20.dp))

        Button(onClick = { valor = (valor - 1)
              .coerceAtLeast(0) }) {
            Text(text = "Decrementar")
        }

        Spacer(Modifier.height(20.dp))

        Button(onClick = { valor = 0}) {
            Text(text = "Reiniciar")
        }
    }
}

@Composable
fun Tres (modifier: Modifier = Modifier){

    var mostrarTexto by remember {mutableStateOf(false) }

    Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        if (mostrarTexto){
            Text(text = "Olá Bem-Vindo ao Kotlin!")
        }

        Button(onClick = { mostrarTexto = !mostrarTexto }) {
            Text(text = "Mostrar Mensagem")
        }
    }
}

@Composable
fun Quatro (modifier: Modifier = Modifier){

    var cor by remember { mutableStateOf(true)}
    var corResutado = when(cor){
        true -> Color.Blue
        else -> Color.Red
    }
    
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "Olá Kotlin!", color = corResutado)

        Button(onClick = {cor = !cor}) {
            Text(text = "Trocar cor")
        }
    }
}

@Composable
fun Cinco(modifier: Modifier = Modifier){

    var nome by remember { mutableStateOf(" ") }
    
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "Olá $nome")

        TextField(value = nome,
                  onValueChange = { novoNome -> nome = novoNome},
                  label = {Text(text = "Digite seu nome: "
                  )})
    }
}

@Composable
fun Seis(modifier: Modifier = Modifier){

    var idade by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        TextField(value = idade,
                  onValueChange = {novaIdade -> idade = novaIdade},
                  label = { Text(text = "Digite sua idade: "
                  )})

        Button(onClick = {
            val idadeInt = idade.toIntOrNull()

            if (idadeInt != null){
                if (idadeInt < 18) {
                    mensagem = "Menor de idade"
                }else if(idadeInt >= 18) {
                    mensagem = "Maior de idade"
                }
            }else if (idadeInt == null){
                    mensagem = "Digite uma idade válida"
            }

        }) { Text(text = "Validar")
        }

        Text(text = mensagem)
    }
}

@Composable
fun Sete(modifier: Modifier = Modifier){

    var valor1 by remember { mutableStateOf("") }
    var valor2 by remember { mutableStateOf("") }
    var somar by remember { mutableStateOf(0) }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        TextField(value = valor1,
                  onValueChange = {novoValor1 -> valor1 = novoValor1},
                  label = { Text(text = "Digite o primeiro valor: "
                  )})

        TextField(value = valor2,
                  onValueChange = {novoValor2 -> valor2 = novoValor2},
                  label = { Text(text = "Digite o segundo valor: "
                  )})

        Button(onClick = { somar = valor1.toInt() + valor2.toInt() }) {
            Text(text = "Somar")
        }
        
        Text(text = somar.toString())
    }
}

@Composable
fun Oito(modifier: Modifier = Modifier){

    var valor by remember { mutableStateOf(0) }
    var mensagem by remember { mutableStateOf("") }
    var ativo by remember { mutableStateOf(true) }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        
        Text(text = valor.toString())
        Button(onClick = {if (valor < 10){ valor++ } else { ativo = false }},
               enabled = ativo) {
            Text(text = "Clique para aicionar")

            if (!ativo){
                mensagem = "Limite atingido"
            }
        }

        Text(text = mensagem)
    }
}

@Composable
fun Nove(modifier: Modifier = Modifier){

    var numero by remember { mutableStateOf(0) }
    var mensagem by remember { mutableStateOf("") }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = numero.toString())

        Button(onClick = {numero = (1..100)
               .random()}) {

            Text(text = "Gerar número")

            if (numero % 2 == 0){
                mensagem = "Número par"
            }else{
                mensagem = "Número impar"
            }
        }

        Text(text = mensagem)
    }
}

@Composable
fun Dez(modifier: Modifier = Modifier){
    
    var nomeUser by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }
    
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        TextField(value = nomeUser,
                  onValueChange = {novoNomeUser -> nomeUser = novoNomeUser},
                  label = { Text(text = "Digite o nome de usuário")})

        TextField(value = senha,
                  onValueChange = {novaSenha -> senha = novaSenha},
                  label = { Text(text = "Digite a senha")})
        
        Button(onClick = {
            if (nomeUser == "admin" && senha == "1234"){
                mensagem = "Login realizado"
            }else{
                mensagem = "Usuário ou senha inválidos"
            }

        }) { Text(text = "Entrar")
        }

        Text(text = mensagem)
    }
}

@Composable
fun Desafio(modifier: Modifier =Modifier){

    var cor by remember { mutableStateOf(true) }
    var corFundo = when(cor){
        true -> Color.Black
        else -> Color.White
    }
    var corLetra = when(cor){
        true -> Color.White
        else -> Color.Black
    }

    Column(modifier = modifier
        .background(corFundo),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        
        Text(text = "Mudar do tema claro para o escuro", color = corLetra)

        Button(onClick = {cor = !cor}) {
            Text(text = "Mudar Tema", color = corLetra)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IncrementadorTheme {

        Um()
        Dois()
        Tres()
        Quatro()
        Cinco()
        Seis()
        Sete()
        Oito()
        Nove()
        Dez()
        Desafio()

    }
}