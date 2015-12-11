.class Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;
.super Landroid/os/AsyncTask;
.source "MRAIDWebView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/renderers/html/MRAIDWebView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "downloadHTMLContentTask"
.end annotation

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
.field private fail:Ljava/lang/Boolean;

.field private script:Ljava/lang/String;

.field final synthetic this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

.field private url:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ltv/freewheel/renderers/html/MRAIDWebView;)V
    .locals 1

    .prologue
    .line 470
    iput-object p1, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 471
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->fail:Ljava/lang/Boolean;

    .line 472
    const-string v0, ""

    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->script:Ljava/lang/String;

    .line 473
    const-string v0, ""

    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->url:Ljava/lang/String;

    return-void
.end method

.method synthetic constructor <init>(Ltv/freewheel/renderers/html/MRAIDWebView;Ltv/freewheel/renderers/html/MRAIDWebView$1;)V
    .locals 0
    .param p1, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;
    .param p2, "x1"    # Ltv/freewheel/renderers/html/MRAIDWebView$1;

    .prologue
    .line 470
    invoke-direct {p0, p1}, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;-><init>(Ltv/freewheel/renderers/html/MRAIDWebView;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 470
    check-cast p1, [Ljava/lang/String;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->doInBackground([Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p1, "urls"    # [Ljava/lang/String;

    .prologue
    const/4 v11, 0x0

    .line 477
    const/4 v10, 0x1

    aget-object v10, p1, v10

    iput-object v10, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->script:Ljava/lang/String;

    .line 478
    aget-object v9, p1, v11

    .line 479
    .local v9, "urlString":Ljava/lang/String;
    const-string v2, ""

    .line 480
    .local v2, "description":Ljava/lang/String;
    const-string v4, ""

    .line 481
    .local v4, "htmlcontent":Ljava/lang/String;
    invoke-static {v9}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_4

    .line 482
    iput-object v9, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->url:Ljava/lang/String;

    .line 483
    const/4 v1, 0x0

    .line 484
    .local v1, "conn":Ljava/net/HttpURLConnection;
    const/4 v7, 0x0

    .line 487
    .local v7, "redirect_count":I
    :cond_0
    :try_start_0
    new-instance v8, Ljava/net/URL;

    invoke-direct {v8, v9}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 488
    .local v8, "url":Ljava/net/URL;
    invoke-virtual {v8}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v10

    check-cast v10, Ljava/net/HttpURLConnection;

    move-object v0, v10

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v1, v0

    .line 489
    const/4 v10, 0x0

    invoke-virtual {v1, v10}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 490
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->connect()V

    .line 491
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v10

    const/16 v11, 0x12e

    if-eq v10, v11, :cond_3

    .line 492
    new-instance v6, Ljava/io/BufferedReader;

    new-instance v10, Ljava/io/InputStreamReader;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v6, v10}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 493
    .local v6, "reader":Ljava/io/BufferedReader;
    const-string v5, ""

    .line 494
    .local v5, "line":Ljava/lang/String;
    :goto_0
    invoke-virtual {v6}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 495
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\n"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 497
    :cond_1
    invoke-virtual {v6}, Ljava/io/BufferedReader;->close()V

    .line 498
    const/4 v10, 0x0

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v10

    iput-object v10, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->fail:Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 519
    .end local v1    # "conn":Ljava/net/HttpURLConnection;
    .end local v5    # "line":Ljava/lang/String;
    .end local v6    # "reader":Ljava/io/BufferedReader;
    .end local v7    # "redirect_count":I
    .end local v8    # "url":Ljava/net/URL;
    :cond_2
    :goto_1
    iget-object v10, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->fail:Ljava/lang/Boolean;

    invoke-virtual {v10}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    if-eqz v10, :cond_5

    .end local v2    # "description":Ljava/lang/String;
    :goto_2
    return-object v2

    .line 501
    .restart local v1    # "conn":Ljava/net/HttpURLConnection;
    .restart local v2    # "description":Ljava/lang/String;
    .restart local v7    # "redirect_count":I
    .restart local v8    # "url":Ljava/net/URL;
    :cond_3
    :try_start_1
    const-string v10, "Location"

    invoke-virtual {v1, v10}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 502
    add-int/lit8 v7, v7, 0x1

    .line 504
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_1
    .catch Ljava/net/MalformedURLException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 505
    const/4 v1, 0x0

    .line 506
    const/4 v10, 0x3

    if-le v7, v10, :cond_0

    goto :goto_1

    .line 507
    .end local v8    # "url":Ljava/net/URL;
    :catch_0
    move-exception v3

    .line 508
    .local v3, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v3}, Ljava/net/MalformedURLException;->toString()Ljava/lang/String;

    move-result-object v2

    .line 514
    goto :goto_1

    .line 509
    .end local v3    # "e":Ljava/net/MalformedURLException;
    :catch_1
    move-exception v3

    .line 510
    .local v3, "e":Ljava/io/IOException;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Failed to get content from creative url."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v3}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 511
    if-eqz v1, :cond_2

    .line 512
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_1

    .line 516
    .end local v1    # "conn":Ljava/net/HttpURLConnection;
    .end local v3    # "e":Ljava/io/IOException;
    .end local v7    # "redirect_count":I
    :cond_4
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Invalid url:"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_1

    :cond_5
    move-object v2, v4

    .line 519
    goto :goto_2
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 470
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 524
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->fail:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 525
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    invoke-virtual {v0, p1}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    .line 526
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDWebView;->bridge:Ltv/freewheel/renderers/html/HTMLRenderer;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$900(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/renderers/html/HTMLRenderer;

    move-result-object v0

    const/16 v1, 0x64

    invoke-virtual {v0, v1, p1}, Ltv/freewheel/renderers/html/HTMLRenderer;->mraidLoadFail(ILjava/lang/String;)V

    .line 531
    :goto_0
    return-void

    .line 528
    :cond_0
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    const-string v1, ""

    # invokes: Ltv/freewheel/renderers/html/MRAIDWebView;->injectScriptToHTML(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v0, p1, v1}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$1000(Ltv/freewheel/renderers/html/MRAIDWebView;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 529
    .local v2, "htmlcontent":Ljava/lang/String;
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->url:Ljava/lang/String;

    const-string v3, "text/html"

    const-string v4, "utf8"

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ltv/freewheel/renderers/html/MRAIDWebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
