.class Lcom/comcast/cim/android/view/common/CALDialogFragment$5;
.super Ljava/lang/Object;
.source "CALDialogFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/CALDialogFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/CALDialogFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/CALDialogFragment;

    .prologue
    .line 189
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$5;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 192
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$5;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->dismiss()V

    .line 194
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 195
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "uri"

    iget-object v3, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$5;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$string;->URL_NEEDID:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 196
    const-string v2, "openAnotherAppDlg"

    invoke-static {v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v1

    .line 197
    .local v1, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 198
    iget-object v2, p0, Lcom/comcast/cim/android/view/common/CALDialogFragment$5;->this$0:Lcom/comcast/cim/android/view/common/CALDialogFragment;

    invoke-virtual {v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    const-string v3, "openAnotherAppDlg"

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 199
    return-void
.end method
