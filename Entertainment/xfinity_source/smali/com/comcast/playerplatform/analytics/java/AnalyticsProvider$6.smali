.class Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$6;
.super Ljava/lang/Object;
.source "AnalyticsProvider.java"

# interfaces
.implements Lcom/comcast/playerplatform/analytics/java/util/ObjectStream;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic val$appContext:Landroid/content/Context;

.field final synthetic val$fileName:Ljava/lang/String;


# virtual methods
.method public objectInputStream()Ljava/io/ObjectInputStream;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 477
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$6;->val$appContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$6;->val$fileName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/content/Context;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object v0

    .line 478
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v1, Ljava/io/ObjectInputStream;

    invoke-direct {v1, v0}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V

    .line 479
    .local v1, "ois":Ljava/io/ObjectInputStream;
    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$300()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "objectInputStream created"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 480
    return-object v1
.end method

.method public objectOutputStream()Ljava/io/ObjectOutputStream;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 485
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$6;->val$appContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider$6;->val$fileName:Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v0

    .line 486
    .local v0, "fos":Ljava/io/FileOutputStream;
    new-instance v1, Ljava/io/ObjectOutputStream;

    invoke-direct {v1, v0}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 487
    .local v1, "oos":Ljava/io/ObjectOutputStream;
    # getter for: Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->access$300()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "objectOutputStream created"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 488
    return-object v1
.end method
