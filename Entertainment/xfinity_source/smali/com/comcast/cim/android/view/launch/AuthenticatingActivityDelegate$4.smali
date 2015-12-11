.class Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$4;
.super Ljava/lang/Object;
.source "AuthenticatingActivityDelegate.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->onResume()V
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
    .line 167
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$4;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate$4;->this$0:Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivityDelegate;->checkForUserUpgrade()V

    .line 171
    return-void
.end method
