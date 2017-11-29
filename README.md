<h1>Calculadora Android</h1>
<h2>Aplicación Android con la funcionalidad de una sencilla calculadora</h2>

<p>Un pequeño proyecto basado en la funcionalidad de una calculadora sencilla. Puedes descargar el apk de la tienda <b>Google Play</b> o en <a target="_blank" href="https://play.google.com/store/apps/details?id=com.mapasgoogle.javi.calculator">este link</a>.</p>
<p>Puede realizar cualquiera de las operaciones sencillas que realiza una calculadora: </p>
<ul>
  <li>Sumas.</li>
  <li>Restas.</li>
  <li>Multiplicaciones.</li>
  <li>Divisiones.</li>
  <li>Porcentaje de una cantidad dada.</li>
</ul>

<p>El proyecto está realizado íntegramente con el IDE <b>Android Studio</b>. Consta de tres partes principales: </p>
<ul>
  <li>La clase <b>Operation</b>, con los atributos <b>numberOne</b>, <b>numberTwo</b> y <b>operation1</b> (guardará la operación pendiente según el botón operador pulsado).</li>
  <li>La clase principal: <b>MainActivity</b>, la cual ejecuta la aplicación y controla los eventos según tecla pulsada.</li>
  <li>El layout de la aplicación (sólo hay uno puesto que es una app sencilla) <b>activity_main.xml</b>. Estará formado por varios LinearLayout para la disposición de las teclas. Arriba tenemos la pantalla principal donde se muestran los resultados y teclas pulsadas y a su derecha la tecla para borrar un dígito si nos hemos equivocado. A partir de la segunda fila y hasta la 5ª podremos ver las teclas básicas para realzar las operaciones anteriormente mencionadas.</li>
</ul>

