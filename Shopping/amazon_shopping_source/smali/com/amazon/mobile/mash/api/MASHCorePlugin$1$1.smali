.class Lcom/amazon/mobile/mash/api/MASHCorePlugin$1$1;
.super Ljava/lang/Object;
.source "MASHCorePlugin.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1$1;->this$1:Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 86
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1$1;->this$1:Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;

    iget-object v0, v0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$1;->val$callback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v0, p2}, Lorg/apache/cordova/CallbackContext;->success(I)V

    .line 87
    return-void
.end method
