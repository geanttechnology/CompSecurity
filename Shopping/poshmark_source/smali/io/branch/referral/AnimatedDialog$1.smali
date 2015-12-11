.class Lio/branch/referral/AnimatedDialog$1;
.super Ljava/lang/Object;
.source "AnimatedDialog.java"

# interfaces
.implements Landroid/content/DialogInterface$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/AnimatedDialog;->init(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/branch/referral/AnimatedDialog;


# direct methods
.method constructor <init>(Lio/branch/referral/AnimatedDialog;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lio/branch/referral/AnimatedDialog$1;->this$0:Lio/branch/referral/AnimatedDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/content/DialogInterface;ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "arg0"    # Landroid/content/DialogInterface;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 70
    const/4 v0, 0x4

    if-ne p2, v0, :cond_0

    .line 71
    iget-object v0, p0, Lio/branch/referral/AnimatedDialog$1;->this$0:Lio/branch/referral/AnimatedDialog;

    # invokes: Lio/branch/referral/AnimatedDialog;->slideClose()V
    invoke-static {v0}, Lio/branch/referral/AnimatedDialog;->access$000(Lio/branch/referral/AnimatedDialog;)V

    .line 73
    :cond_0
    const/4 v0, 0x1

    return v0
.end method
