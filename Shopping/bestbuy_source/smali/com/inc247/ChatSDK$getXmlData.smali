.class Lcom/inc247/ChatSDK$getXmlData;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDK;


# direct methods
.method private constructor <init>(Lcom/inc247/ChatSDK;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/inc247/ChatSDK;Lcom/inc247/ChatSDK$getXmlData;)V
    .locals 0

    .prologue
    .line 181
    invoke-direct {p0, p1}, Lcom/inc247/ChatSDK$getXmlData;-><init>(Lcom/inc247/ChatSDK;)V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/inc247/ChatSDK$getXmlData;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 200
    const-string v0, ""

    .line 202
    sget-object v0, Lcom/inc247/ChatSDKResources;->Chatsdk_Config_URL:Ljava/lang/String;

    .line 204
    :try_start_0
    new-instance v1, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v1}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 206
    new-instance v2, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v2, v1}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/params/HttpParams;)V

    .line 208
    new-instance v1, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v1, v0}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 211
    invoke-static {v2, v1}, Lp;->a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    .line 212
    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    .line 213
    invoke-static {v0}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v0

    .line 215
    invoke-static {}, Ljavax/xml/parsers/DocumentBuilderFactory;->newInstance()Ljavax/xml/parsers/DocumentBuilderFactory;

    move-result-object v1

    .line 217
    invoke-virtual {v1}, Ljavax/xml/parsers/DocumentBuilderFactory;->newDocumentBuilder()Ljavax/xml/parsers/DocumentBuilder;

    move-result-object v1

    .line 218
    new-instance v2, Lorg/xml/sax/InputSource;

    invoke-direct {v2}, Lorg/xml/sax/InputSource;-><init>()V

    .line 219
    new-instance v3, Ljava/io/StringReader;

    invoke-direct {v3, v0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lorg/xml/sax/InputSource;->setCharacterStream(Ljava/io/Reader;)V

    .line 220
    invoke-virtual {v1, v2}, Ljavax/xml/parsers/DocumentBuilder;->parse(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;

    move-result-object v0

    sput-object v0, Lcom/inc247/ChatSDK;->documentDataForReturn:Lorg/w3c/dom/Document;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 224
    :goto_0
    const/4 v0, 0x0

    return-object v0

    .line 221
    :catch_0
    move-exception v0

    .line 222
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/inc247/ChatSDK$getXmlData;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 228
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 229
    # getter for: Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;
    invoke-static {}, Lcom/inc247/ChatSDK;->access$0()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    invoke-virtual {v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonQueueIdParamRetrievalFinished()V

    .line 230
    sget-object v0, Lcom/inc247/ChatSDKResources;->XML_DATA_LOADER_DIALOG:Ljava/lang/String;

    const-string v1, "false"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 232
    :try_start_0
    iget-object v0, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 233
    iget-object v0, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 241
    :cond_0
    :goto_0
    sget-object v0, Lcom/inc247/ChatSDK;->documentDataForReturn:Lorg/w3c/dom/Document;

    if-eqz v0, :cond_3

    .line 242
    sget-object v0, Lcom/inc247/ChatSDK;->documentDataForReturn:Lorg/w3c/dom/Document;

    .line 243
    const-string v1, "CheckAvailability"

    invoke-interface {v0, v1}, Lorg/w3c/dom/Document;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 242
    sput-object v0, Lcom/inc247/ChatSDK;->contactList:Lorg/w3c/dom/NodeList;

    move v1, v2

    .line 244
    :goto_1
    sget-object v0, Lcom/inc247/ChatSDK;->contactList:Lorg/w3c/dom/NodeList;

    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v0

    if-lt v1, v0, :cond_1

    .line 278
    iget-object v0, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    invoke-virtual {v0}, Lcom/inc247/ChatSDK;->checkAgentAvailability()V

    .line 283
    :goto_2
    return-void

    .line 235
    :catch_0
    move-exception v0

    .line 236
    const-string v0, "ERROR dismissing progress dialog"

    .line 237
    const-string v1, "Please check that the activity used to initialize the dialog is still active and its finish() hasnt been called."

    .line 236
    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 238
    iget-object v0, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/inc247/ChatSDK;->progressDialog:Landroid/app/ProgressDialog;

    goto :goto_0

    .line 245
    :cond_1
    sget-object v0, Lcom/inc247/ChatSDK;->contactList:Lorg/w3c/dom/NodeList;

    invoke-interface {v0, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 246
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_2

    .line 247
    check-cast v0, Lorg/w3c/dom/Element;

    .line 248
    const-string v3, "queue"

    invoke-interface {v0, v3}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v3

    .line 250
    invoke-interface {v3, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    invoke-interface {v3}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v3

    .line 248
    sput-object v3, Lcom/inc247/ChatSDK;->queue:Ljava/lang/String;

    .line 252
    const-string v3, "url"

    invoke-interface {v0, v3}, Lorg/w3c/dom/Element;->getElementsByTagName(Ljava/lang/String;)Lorg/w3c/dom/NodeList;

    move-result-object v0

    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v0

    .line 253
    invoke-interface {v0}, Lorg/w3c/dom/Node;->getTextContent()Ljava/lang/String;

    move-result-object v0

    .line 252
    sput-object v0, Lcom/inc247/ChatSDK;->url:Ljava/lang/String;

    .line 259
    :cond_2
    iget-object v0, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->queueIdAndUrl:Ljava/util/HashMap;

    sget-object v3, Lcom/inc247/ChatSDK;->queue:Ljava/lang/String;

    sget-object v4, Lcom/inc247/ChatSDK;->url:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 267
    :try_start_1
    iget-object v0, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->queueIdFromAppDeveloper:Lorg/json/JSONObject;

    const-string v3, "queueId"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 268
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 269
    iget-object v3, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    iget-object v3, v3, Lcom/inc247/ChatSDK;->queueIdAndUrl:Ljava/util/HashMap;

    invoke-virtual {v3, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sput-object v0, Lcom/inc247/ChatSDK;->queueFromServerData:Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 244
    :goto_3
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 271
    :catch_1
    move-exception v0

    .line 272
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 274
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "{\'Error\':\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "\'}"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 273
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_3

    .line 280
    :cond_3
    # getter for: Lcom/inc247/ChatSDK;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/inc247/ChatSDK;->access$1()Ljava/lang/String;

    move-result-object v0

    const-string v1, "oops  documentDataForReturn is null "

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 184
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 185
    # getter for: Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;
    invoke-static {}, Lcom/inc247/ChatSDK;->access$0()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    invoke-virtual {v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonQueueIdParamRetrievalStarted()V

    .line 186
    sget-object v0, Lcom/inc247/ChatSDKResources;->XML_DATA_LOADER_DIALOG:Ljava/lang/String;

    const-string v1, "false"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 187
    iget-object v0, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    new-instance v1, Landroid/app/ProgressDialog;

    # getter for: Lcom/inc247/ChatSDK;->self:Lcom/inc247/ChatSDK;
    invoke-static {}, Lcom/inc247/ChatSDK;->access$0()Lcom/inc247/ChatSDK;

    move-result-object v2

    iget-object v2, v2, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-direct {v1, v2}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v1, v0, Lcom/inc247/ChatSDK;->progressDialog:Landroid/app/ProgressDialog;

    .line 189
    :try_start_0
    iget-object v0, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->progressDialog:Landroid/app/ProgressDialog;

    const-string v1, "Please wait..."

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 190
    iget-object v0, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 191
    iget-object v0, p0, Lcom/inc247/ChatSDK$getXmlData;->this$0:Lcom/inc247/ChatSDK;

    iget-object v0, v0, Lcom/inc247/ChatSDK;->progressDialog:Landroid/app/ProgressDialog;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setCancelable(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 197
    :cond_0
    :goto_0
    return-void

    .line 192
    :catch_0
    move-exception v0

    .line 193
    const-string v0, "ERROR showing progress dialog"

    .line 194
    const-string v1, "Please check the activity used to initialize the dialog is still active and its finish() hasnt been called."

    .line 193
    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
