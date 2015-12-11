.class public final Lcom/penthera/virtuososdk/utility/CommonUtil$HttpUtils;
.super Ljava/lang/Object;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "HttpUtils"
.end annotation


# direct methods
.method public static dumpHeaders([Lorg/apache/http/Header;)V
    .locals 6
    .param p0, "headers"    # [Lorg/apache/http/Header;

    .prologue
    .line 906
    if-nez p0, :cond_1

    .line 913
    :cond_0
    return-void

    .line 909
    :cond_1
    array-length v2, p0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v0, p0, v1

    .line 911
    .local v0, "h":Lorg/apache/http/Header;
    const-string v3, "HttpUtils"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-interface {v0}, Lorg/apache/http/Header;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, " : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 909
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method
