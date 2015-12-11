.class final Lcom/adobe/mobile/StaticMethods$4;
.super Ljava/util/HashMap;
.source "StaticMethods.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/StaticMethods;->setAdvertisingIdentifier(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic val$adid:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 426
    iput-object p1, p0, Lcom/adobe/mobile/StaticMethods$4;->val$adid:Ljava/lang/String;

    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 427
    const-string v0, "20914"

    iget-object v1, p0, Lcom/adobe/mobile/StaticMethods$4;->val$adid:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mobile/StaticMethods$4;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 428
    return-void
.end method
