.class Lcom/igexin/sdk/SdkActivity$4;
.super Ljava/lang/Object;
.source "SdkActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/igexin/sdk/SdkActivity;->showDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/igexin/sdk/SdkActivity;


# direct methods
.method constructor <init>(Lcom/igexin/sdk/SdkActivity;)V
    .locals 0

    .prologue
    .line 205
    iput-object p1, p0, Lcom/igexin/sdk/SdkActivity$4;->this$0:Lcom/igexin/sdk/SdkActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/content/DialogInterface;ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x1

    .line 209
    packed-switch p2, :pswitch_data_0

    .line 216
    :goto_0
    return v1

    .line 211
    :pswitch_0
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 212
    iget-object v0, p0, Lcom/igexin/sdk/SdkActivity$4;->this$0:Lcom/igexin/sdk/SdkActivity;

    invoke-virtual {v0}, Lcom/igexin/sdk/SdkActivity;->finish()V

    goto :goto_0

    .line 209
    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_0
    .end packed-switch
.end method
