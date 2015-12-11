.class public Lcom/comcast/cim/httpcomponentsandroid/client/entity/UrlEncodedFormEntity;
.super Lcom/comcast/cim/httpcomponentsandroid/entity/StringEntity;
.source "UrlEncodedFormEntity.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# direct methods
.method public constructor <init>(Ljava/util/List;Ljava/lang/String;)V
    .locals 2
    .param p2, "encoding"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<+",
            "Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/UnsupportedEncodingException;
        }
    .end annotation

    .prologue
    .line 59
    .local p1, "parameters":Ljava/util/List;, "Ljava/util/List<+Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    invoke-static {p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/URLEncodedUtils;->format(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/entity/StringEntity;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "application/x-www-form-urlencoded; charset="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    if-eqz p2, :cond_0

    .end local p2    # "encoding":Ljava/lang/String;
    :goto_0
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/entity/UrlEncodedFormEntity;->setContentType(Ljava/lang/String;)V

    .line 62
    return-void

    .line 60
    .restart local p2    # "encoding":Ljava/lang/String;
    :cond_0
    const-string p2, "ISO-8859-1"

    goto :goto_0
.end method
