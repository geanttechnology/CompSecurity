.class Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$2;
.super Ljava/lang/Object;
.source "ExternalLinkPromptActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$2;->this$0:Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 47
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 48
    return-void
.end method
