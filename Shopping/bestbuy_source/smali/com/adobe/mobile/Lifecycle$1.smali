.class final Lcom/adobe/mobile/Lifecycle$1;
.super Ljava/util/HashMap;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/Lifecycle;->checkForPushMessageClickThrough(Landroid/app/Activity;)V
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


# instance fields
.field final synthetic val$pushMessageID:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 575
    iput-object p1, p0, Lcom/adobe/mobile/Lifecycle$1;->val$pushMessageID:Ljava/lang/String;

    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    const-string v0, "a.push.payloadId"

    iget-object v1, p0, Lcom/adobe/mobile/Lifecycle$1;->val$pushMessageID:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mobile/Lifecycle$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
