.class Lcom/comcast/cim/android/view/launch/LaunchActivity$2;
.super Ljava/lang/Object;
.source "LaunchActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/launch/LaunchActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/launch/LaunchActivity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/launch/LaunchActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/launch/LaunchActivity;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity$2;->this$0:Lcom/comcast/cim/android/view/launch/LaunchActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/cim/android/view/launch/LaunchActivity$2;->this$0:Lcom/comcast/cim/android/view/launch/LaunchActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/launch/LaunchActivity;->finish()V

    .line 61
    return-void
.end method
