.class Lcom/amazon/mobile/mash/api/MASHCorePlugin$2$1;
.super Ljava/lang/Object;
.source "MASHCorePlugin.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2$1;->this$1:Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 149
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2$1;->this$1:Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;

    iget-object v0, v0, Lcom/amazon/mobile/mash/api/MASHCorePlugin$2;->val$callback:Lorg/apache/cordova/CallbackContext;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lorg/apache/cordova/CallbackContext;->success(I)V

    .line 150
    return-void
.end method
