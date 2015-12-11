.class Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$3;
.super Ljava/lang/Object;
.source "ExternalLinkPromptActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


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
    .line 52
    iput-object p1, p0, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$3;->this$0:Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$3;->this$0:Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;->finish()V

    .line 56
    return-void
.end method
