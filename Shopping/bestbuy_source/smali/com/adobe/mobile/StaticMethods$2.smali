.class final Lcom/adobe/mobile/StaticMethods$2;
.super Ljava/util/HashMap;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/StaticMethods;->setPushIdentifier(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 398
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 399
    const-string v0, "a.push.optin"

    const-string v1, "True"

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mobile/StaticMethods$2;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
