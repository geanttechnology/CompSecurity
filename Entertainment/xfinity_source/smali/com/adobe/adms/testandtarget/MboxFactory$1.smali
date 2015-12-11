.class Lcom/adobe/adms/testandtarget/MboxFactory$1;
.super Ljava/lang/Object;
.source "MboxFactory.java"

# interfaces
.implements Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/adms/testandtarget/MboxFactory;->getMboxResponse(Lcom/adobe/adms/testandtarget/Mbox;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

.field final synthetic val$mbox:Lcom/adobe/adms/testandtarget/Mbox;


# direct methods
.method constructor <init>(Lcom/adobe/adms/testandtarget/MboxFactory;Lcom/adobe/adms/testandtarget/Mbox;)V
    .locals 0

    .prologue
    .line 304
    iput-object p1, p0, Lcom/adobe/adms/testandtarget/MboxFactory$1;->this$0:Lcom/adobe/adms/testandtarget/MboxFactory;

    iput-object p2, p0, Lcom/adobe/adms/testandtarget/MboxFactory$1;->val$mbox:Lcom/adobe/adms/testandtarget/Mbox;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 304
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/adobe/adms/testandtarget/MboxFactory$1;->call(Ljava/lang/String;)V

    return-void
.end method

.method public call(Ljava/lang/String;)V
    .locals 1
    .param p1, "item"    # Ljava/lang/String;

    .prologue
    .line 307
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/MboxFactory$1;->val$mbox:Lcom/adobe/adms/testandtarget/Mbox;

    invoke-virtual {v0, p1}, Lcom/adobe/adms/testandtarget/Mbox;->callOnLoadConsumers(Ljava/lang/String;)V

    .line 308
    return-void
.end method
