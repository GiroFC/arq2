int led1 = 13;
int led2 = 12;
int led3 = 11;
int led4 = 10;
String teste;
String a[100];
char a1;
char x;
char y;
char w;
char t = '1';
int xi;
int yi;
int wi;
int xb[8]; // X binario
int yb[8]; // Y binario
int wb[8]; // W binario
int i = 4;
int j = 0;
int k = 4;
int num;
int exp1;
int aux;
int aux1;
int soma;
int eledois; // num elevado a dois

void setup()
{
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);
  Serial.begin(9600);
}
/**
 * Função que lê uma string da Serial
 * e retorna-a
 */
String leStringSerial()
{
  String conteudo = "";
  char caractere;

  // Enquanto receber algo pela serial
  while (Serial.available() > 0)
  {
    // Lê byte da serial
    caractere = Serial.read();
    // Ignora caractere de quebra de linha
    if (caractere != '\n')
    {
      // Concatena valores
      conteudo.concat(caractere);
    }
    // Aguarda buffer serial ler próximo caractere
    delay(10);
  }

  return conteudo;
}

void loop()
{
  if (Serial.available() > 0)
  {
    a[i] = leStringSerial();
    Serial.println(a[i]);
    i++;
  }
  // Enquanto não encontra "FIM"
  if (a[i - 1] == "FIM")
  {
    a[0] = ("%d", k);
    a[1] = "0";
    a[2] = "0";
    a[3] = "0";
    while (k < i)
    {
      xi = a[k][0];
      yi = a[k][1];
      // Checa posição na tabela ASCII
      // Para conversão em hex
      if (xi < 58)
      {
        xi -= 48;
      }
      else
        xi -= 55;
      if (yi < 58)
      {
        yi -= 48;
      }
      else
        yi -= 55;
      // conversao bin
      for (aux = 7; aux >= 0; aux--)
      {
        if (xi % 2 == 0)
        {
          xb[aux] = 0;
          xi = xi / 2;
        }
        else
        {
          xb[aux] = 1;
          xi = xi / 2;
        }
      }
      for (aux = 7; aux >= 0; aux--)
      {
        if (yi % 2 == 0)
        {
          yb[aux] = 0;
          yi = yi / 2;
        }
        else
        {
          yb[aux] = 1;
          yi = yi / 2;
        }
      }
      Serial.print("- >|");
      j = 0;
      while (j < i - 1)
      {
        Serial.print(a[j] + "|");
        j++;
      }
      // pega cada char de uma instrução, e passa seu valor para: x, y ou w.
      // Ex: C6B, x = a[k][0] = 'C';  y = a[k][1] = '6'; w = a[k][2] = 'B'.
      w = a[k][2];
      x = a[k][0];
      y = a[k][1];
      if (w == '0')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          if (xb[aux] == 1)
          {
            wb[aux] = 0;
          }
          else
            wb[aux] = 1;
        }
      }
      // Checa operações na ULA
      if (w == '1')
      {
        soma = 0;
        for (aux = 7; aux >= 0; aux--)
        {
          if (xb[aux] + yb[aux] + soma <= 1)
          {
            wb[aux] = xb[aux] + yb[aux] + soma;
            soma = 0;
          }
          if (xb[aux] + yb[aux] + soma == 2)
          {
            wb[aux] = 0;
            soma = 1;
          }
          if (xb[aux] + yb[aux] + soma == 3)
          {
            wb[aux] = 1;
            soma = 1;
          }
          if (wb[aux] == 1)
          {
            wb[aux] = 0;
          }
          else
            wb[aux] = 1;
        }
      }
      if (w == '2')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          if (xb[aux] == 1)
          {
            xb[aux] = 0;
          }
          else
            xb[aux] = 1;

          if (xb[aux] == 1 && yb[aux] == 1)
          {
            wb[aux] = 1;
          }
          else
            wb[aux] = 0;
        }
      }
      if (w == '3')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          wb[aux] = 0;
        }
      }
      if (w == '4')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          if (xb[aux] == 1 && yb[aux] == 1)
          {
            wb[aux] = 0;
          }
          else
            wb[aux] = 1;
        }
      }

      if (w == '5')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          if (yb[aux] == 1)
          {
            wb[aux] = 0;
          }
          else
            wb[aux] = 1;
        }
      }
      if (w == '6')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          if (yb[aux] != xb[aux])
          {
            wb[aux] = 1;
          }
          else
            wb[aux] = 0;
        }
      }

      if (w == '7')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          if (yb[aux] == 1)
          {
            yb[aux] = 0;
          }
          else
            yb[aux] = 1;
          if (xb[aux] == 1 && yb[aux] == 1)
          {
            wb[aux] = 1;
          }
          else
            wb[aux] = 0;
        }
      }
      if (w == '8')
      {
        soma = 0;
        for (aux = 7; aux >= 0; aux--)
        {
          if (xb[aux] == 1)
          {
            xb[aux] = 0;
          }
          else
            xb[aux] = 1;
          if (xb[aux] + yb[aux] + soma <= 1)
          {
            wb[aux] = xb[aux] + yb[aux] + soma;
            soma = 0;
          }
          if (xb[aux] + yb[aux] + soma == 2)
          {
            wb[aux] = 0;
            soma = 1;
          }
          if (xb[aux] + yb[aux] + soma == 3)
          {
            wb[aux] = 1;
            soma = 1;
          }
        }
      }
      if (w == '9')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          if (yb[aux] != xb[aux])
          {
            wb[aux] = 0;
          }
          else
            wb[aux] = 1;
        }
      }
      if (w == 'A')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          wb[aux] = yb[aux];
        }
      }
      if (w == 'B')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          if (xb[aux] == 1 && yb[aux] == 1)
          {
            wb[aux] = 1;
          }
          else
            wb[aux] = 0;
        }
      }
      if (w == 'C')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          wb[aux] = 1;
        }
      }
      if (w == 'D')
      {
        soma = 0;
        for (aux = 7; aux >= 0; aux--)
        {
          if (yb[aux] == 1)
          {
            yb[aux] = 0;
          }
          else
            yb[aux] = 1;
          if (xb[aux] + yb[aux] + soma <= 1)
          {
            wb[aux] = xb[aux] + yb[aux] + soma;
            soma = 0;
          }
          if (xb[aux] + yb[aux] + soma == 2)
          {
            wb[aux] = 0;
            soma = 1;
          }
          if (xb[aux] + yb[aux] + soma == 3)
          {
            wb[aux] = 1;
            soma = 1;
          }
        }
      }
      if (w == 'E')
      {
        soma = 0;
        for (aux = 7; aux >= 0; aux--)
        {
          if (xb[aux] + yb[aux] + soma <= 1)
          {
            wb[aux] = xb[aux] + yb[aux] + soma;
            soma = 0;
          }
          if (xb[aux] + yb[aux] + soma == 2)
          {
            wb[aux] = 0;
            soma = 1;
          }
          if (xb[aux] + yb[aux] + soma == 3)
          {
            wb[aux] = 1;
            soma = 1;
          }
        }
      }
      if (w == 'F')
      {
        for (aux = 7; aux >= 0; aux--)
        {
          wb[aux] = xb[aux];
        }
      } // Fim instruções

      if (wb[7] == 1)
      {
        digitalWrite(led4, 1);
      }
      else
        digitalWrite(led4, 0);

      if (wb[6] == 1)
      {
        digitalWrite(led3, 1);
      }
      else
        digitalWrite(led3, 0);
      if (wb[5] == 1)
      {
        digitalWrite(led2, 1);
      }
      else
        digitalWrite(led2, 0);
      if (wb[4] == 1)
      {
        digitalWrite(led1, 1);
      }
      else
        digitalWrite(led1, 0);
      wi = 0;
      exp1 = 0;
      for (aux = 7; aux >= 4; aux--)
      {
        eledois = pow(2, exp1);
        if (eledois % 2 != 0 && eledois != 1)
        {
          eledois += 1;
        }
        wi += wb[aux] * eledois;
        exp1++;
      }
      if (wi <= 9)
      {
        w = ("%c", (wi + 48));
      }
      else
      {
        w = ("%c", (wi + 55));
      }
      a[1] = w;
      a[2] = x;
      a[3] = y;
      k++;
      a[0] = ("%d", k);
      // for (aux = 0; aux <= 7; aux++) {
      // Serial.print(wb[aux]);
      // }
      Serial.println(" ");

      delay(2000);
    }
    delay(10000000);
  }
}