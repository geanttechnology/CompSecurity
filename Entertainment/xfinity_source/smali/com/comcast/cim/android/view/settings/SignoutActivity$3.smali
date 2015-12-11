.class Lcom/comcast/cim/android/view/settings/SignoutActivity$3;
.super Ljava/lang/Object;
.source "SignoutActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/settings/SignoutActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/settings/SignoutActivity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/settings/SignoutActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/settings/SignoutActivity;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/comcast/cim/android/view/settings/SignoutActivity$3;->this$0:Lcom/comcast/cim/android/view/settings/SignoutActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 46
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 47
    return-void
.end method
