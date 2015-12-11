.class Ltv/freewheel/renderers/temporal/VideoAdView$5;
.super Ljava/lang/Object;
.source "VideoAdView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/renderers/temporal/VideoAdView;->tryToGetRedirectedUrl(Ljava/lang/String;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

.field final synthetic val$timeoutMs:I

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/temporal/VideoAdView;Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 556
    iput-object p1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    iput-object p2, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->val$url:Ljava/lang/String;

    iput p3, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->val$timeoutMs:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 558
    const/4 v3, 0x0

    .line 559
    .local v3, "error":Ljava/lang/Exception;
    iget-object v6, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    iget-object v7, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->val$url:Ljava/lang/String;

    # setter for: Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;
    invoke-static {v6, v7}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$1202(Ltv/freewheel/renderers/temporal/VideoAdView;Ljava/lang/String;)Ljava/lang/String;

    .line 560
    const/4 v4, 0x0

    .line 562
    .local v4, "urlConnection":Ljava/net/HttpURLConnection;
    :try_start_0
    new-instance v5, Ljava/net/URL;

    iget-object v6, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->val$url:Ljava/lang/String;

    invoke-direct {v5, v6}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 563
    .local v5, "url_":Ljava/net/URL;
    invoke-virtual {v5}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v6

    move-object v0, v6

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v4, v0

    .line 564
    iget v6, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->val$timeoutMs:I

    invoke-virtual {v4, v6}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 565
    iget v6, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->val$timeoutMs:I

    invoke-virtual {v4, v6}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 566
    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Ljava/net/HttpURLConnection;->setInstanceFollowRedirects(Z)V

    .line 567
    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    .line 568
    .local v1, "code":I
    const/16 v6, 0x12e

    if-ne v1, v6, :cond_0

    .line 569
    iget-object v6, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v6}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$000(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/utils/Logger;

    move-result-object v6

    const-string v7, "tryToGetRedirectedUrl asset url is a redirect url"

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 570
    iget-object v6, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    const-string v7, "Location"

    invoke-virtual {v4, v7}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    # setter for: Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;
    invoke-static {v6, v7}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$1202(Ltv/freewheel/renderers/temporal/VideoAdView;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 579
    :cond_0
    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 581
    .end local v1    # "code":I
    .end local v5    # "url_":Ljava/net/URL;
    :goto_0
    iget-object v6, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;
    invoke-static {v6}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$1200(Ltv/freewheel/renderers/temporal/VideoAdView;)Ljava/lang/String;

    move-result-object v6

    if-nez v6, :cond_1

    .line 582
    iget-object v6, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    iget-object v7, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->val$url:Ljava/lang/String;

    # setter for: Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;
    invoke-static {v6, v7}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$1202(Ltv/freewheel/renderers/temporal/VideoAdView;Ljava/lang/String;)Ljava/lang/String;

    .line 584
    :cond_1
    iget-object v6, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;
    invoke-static {v6}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$400(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/renderers/temporal/VideoRenderer;

    move-result-object v6

    iget-object v7, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->adUrl:Ljava/lang/String;
    invoke-static {v7}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$1200(Ltv/freewheel/renderers/temporal/VideoAdView;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7, v3}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onRedirectUrlChecked(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 585
    return-void

    .line 572
    :catch_0
    move-exception v2

    .line 573
    .local v2, "e":Ljava/net/MalformedURLException;
    move-object v3, v2

    .line 574
    :try_start_1
    iget-object v6, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v6}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$000(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/utils/Logger;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "tryToGetRedirectedUrl MalformedURLException for url:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->val$url:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 579
    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_0

    .line 575
    .end local v2    # "e":Ljava/net/MalformedURLException;
    :catch_1
    move-exception v2

    .line 576
    .local v2, "e":Ljava/io/IOException;
    move-object v3, v2

    .line 577
    :try_start_2
    iget-object v6, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v6}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$000(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/utils/Logger;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "tryToGetRedirectedUrl IOException for url:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Ltv/freewheel/renderers/temporal/VideoAdView$5;->val$url:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 579
    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_0

    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v6

    invoke-virtual {v4}, Ljava/net/HttpURLConnection;->disconnect()V

    throw v6
.end method
