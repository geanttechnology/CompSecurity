.class Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$2;
.super Ljava/lang/Object;
.source "AuthenticatingActivityDelegate.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->checkForUserUpgrade()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    .prologue
    .line 107
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$2;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 109
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$2;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    # getter for: Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->activity:Landroid/app/Activity;
    invoke-static {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->access$000(Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 110
    return-void
.end method
