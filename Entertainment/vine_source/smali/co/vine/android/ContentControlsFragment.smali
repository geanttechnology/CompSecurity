.class public Lco/vine/android/ContentControlsFragment;
.super Lco/vine/android/BaseControllerFragment;
.source "ContentControlsFragment.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ContentControlsFragment$ContentControlsListener;
    }
.end annotation


# static fields
.field private static final DIALOG_MAKE_EXPLICIT:I = 0x3

.field private static final DIALOG_MAKE_UNEXPLICIT:I = 0x4

.field private static final DIALOG_PROTECT_POSTS:I = 0x1

.field private static final DIALOG_UNPROTECT_POSTS:I = 0x2

.field private static final STATE_EXPLICIT:Ljava/lang/String; = "state_explicit"

.field private static final STATE_PRIVATE:Ljava/lang/String; = "state_private"


# instance fields
.field private mExplicit:Z

.field private mExplicitIcon:Landroid/widget/ImageView;

.field private mExplicitSwitch:Lco/vine/android/views/SwitchInterface;

.field private mPrivate:Z

.field private mPrivateIcon:Landroid/widget/ImageView;

.field private mPrivateSwitch:Lco/vine/android/views/SwitchInterface;

.field private mProgress:Landroid/app/ProgressDialog;

.field private mView:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lco/vine/android/BaseControllerFragment;-><init>()V

    .line 265
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/ContentControlsFragment;)Landroid/app/ProgressDialog;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/ContentControlsFragment;

    .prologue
    .line 26
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mProgress:Landroid/app/ProgressDialog;

    return-object v0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    const v5, 0x3f8ccccd    # 1.1f

    .line 75
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 76
    invoke-virtual {p0}, Lco/vine/android/ContentControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x41200000    # 10.0f

    new-array v3, v8, [Landroid/widget/TextView;

    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mView:Landroid/view/View;

    const v4, 0x7f0a008d

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    aput-object v0, v3, v6

    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mView:Landroid/view/View;

    const v4, 0x7f0a0093

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    aput-object v0, v3, v7

    invoke-static {v1, v5, v2, v3}, Lco/vine/android/util/ViewUtil;->reduceTextSizeViaFontScaleIfNeeded(Landroid/content/Context;FF[Landroid/widget/TextView;)V

    .line 80
    invoke-virtual {p0}, Lco/vine/android/ContentControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x40a00000    # 5.0f

    new-array v3, v8, [Landroid/widget/TextView;

    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mView:Landroid/view/View;

    const v4, 0x7f0a008f

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    aput-object v0, v3, v6

    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mView:Landroid/view/View;

    const v4, 0x7f0a0095

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    aput-object v0, v3, v7

    invoke-static {v1, v5, v2, v3}, Lco/vine/android/util/ViewUtil;->reduceTextSizeViaFontScaleIfNeeded(Landroid/content/Context;FF[Landroid/widget/TextView;)V

    .line 84
    return-void
.end method

.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 5
    .param p1, "compoundButton"    # Landroid/widget/CompoundButton;
    .param p2, "on"    # Z

    .prologue
    const v4, 0x7f0e0057

    const/4 v3, 0x0

    .line 210
    invoke-virtual {p1}, Landroid/widget/CompoundButton;->getId()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 263
    :goto_0
    return-void

    .line 212
    :sswitch_0
    if-eqz p2, :cond_0

    .line 213
    iget-object v1, p0, Lco/vine/android/ContentControlsFragment;->mPrivateIcon:Landroid/widget/ImageView;

    const v2, 0x7f0201dc

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 214
    const/4 v1, 0x1

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v0

    .line 216
    .local v0, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v1, 0x7f0e0098

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 217
    const v1, 0x7f0e0099

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 218
    invoke-virtual {v0, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 219
    const v1, 0x7f0e0097

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 220
    invoke-virtual {v0, p0, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 221
    invoke-virtual {p0}, Lco/vine/android/ContentControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    goto :goto_0

    .line 223
    .end local v0    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_0
    iget-object v1, p0, Lco/vine/android/ContentControlsFragment;->mPrivateIcon:Landroid/widget/ImageView;

    const v2, 0x7f0201db

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 224
    const/4 v1, 0x2

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v0

    .line 226
    .restart local v0    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v1, 0x7f0e009f

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 227
    const v1, 0x7f0e00a0

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 228
    invoke-virtual {v0, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 229
    const v1, 0x7f0e009e

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 230
    invoke-virtual {v0, p0, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 231
    invoke-virtual {p0}, Lco/vine/android/ContentControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    goto :goto_0

    .line 236
    .end local v0    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :sswitch_1
    if-eqz p2, :cond_1

    .line 237
    iget-object v1, p0, Lco/vine/android/ContentControlsFragment;->mExplicitIcon:Landroid/widget/ImageView;

    const v2, 0x7f0201da

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 238
    const/4 v1, 0x3

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v0

    .line 240
    .restart local v0    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v1, 0x7f0e0093

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 241
    const v1, 0x7f0e0094

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 242
    invoke-virtual {v0, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 243
    const v1, 0x7f0e0095

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 244
    invoke-virtual {v0, p0, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 245
    invoke-virtual {p0}, Lco/vine/android/ContentControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    goto/16 :goto_0

    .line 247
    .end local v0    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_1
    iget-object v1, p0, Lco/vine/android/ContentControlsFragment;->mExplicitIcon:Landroid/widget/ImageView;

    const v2, 0x7f0201d9

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 248
    const/4 v1, 0x4

    invoke-static {v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v0

    .line 250
    .restart local v0    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v1, 0x7f0e009b

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 251
    const v1, 0x7f0e009c

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 252
    invoke-virtual {v0, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 253
    const v1, 0x7f0e009d

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 254
    invoke-virtual {v0, p0, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 255
    invoke-virtual {p0}, Lco/vine/android/ContentControlsFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    goto/16 :goto_0

    .line 210
    :sswitch_data_0
    .sparse-switch
        0x7f0a008e -> :sswitch_0
        0x7f0a0094 -> :sswitch_1
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 49
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onCreate(Landroid/os/Bundle;)V

    .line 50
    new-instance v2, Lco/vine/android/ContentControlsFragment$ContentControlsListener;

    invoke-direct {v2, p0}, Lco/vine/android/ContentControlsFragment$ContentControlsListener;-><init>(Lco/vine/android/ContentControlsFragment;)V

    iput-object v2, p0, Lco/vine/android/ContentControlsFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 52
    if-eqz p1, :cond_0

    .line 53
    const-string v2, "state_private"

    invoke-virtual {p1, v2, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lco/vine/android/ContentControlsFragment;->mPrivate:Z

    .line 54
    const-string v2, "state_explicit"

    invoke-virtual {p1, v2, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lco/vine/android/ContentControlsFragment;->mExplicit:Z

    .line 60
    :goto_0
    new-instance v1, Landroid/app/ProgressDialog;

    invoke-virtual {p0}, Lco/vine/android/ContentControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f0f0037

    invoke-direct {v1, v2, v3}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 61
    .local v1, "prog":Landroid/app/ProgressDialog;
    const v2, 0x7f0e00a2

    invoke-virtual {p0, v2}, Lco/vine/android/ContentControlsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 62
    invoke-virtual {v1, v4}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 63
    iput-object v1, p0, Lco/vine/android/ContentControlsFragment;->mProgress:Landroid/app/ProgressDialog;

    .line 64
    return-void

    .line 56
    .end local v1    # "prog":Landroid/app/ProgressDialog;
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/ContentControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 57
    .local v0, "prefs":Landroid/content/SharedPreferences;
    const-string v2, "settings_private"

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lco/vine/android/ContentControlsFragment;->mPrivate:Z

    .line 58
    const-string v2, "settings_explicit"

    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    iput-boolean v2, p0, Lco/vine/android/ContentControlsFragment;->mExplicit:Z

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 89
    const v0, 0x7f030029

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/ContentControlsFragment;->mView:Landroid/view/View;

    .line 90
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mView:Landroid/view/View;

    return-object v0
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 129
    packed-switch p2, :pswitch_data_0

    .line 206
    :goto_0
    return-void

    .line 131
    :pswitch_0
    packed-switch p3, :pswitch_data_1

    .line 139
    iput-boolean v2, p0, Lco/vine/android/ContentControlsFragment;->mPrivate:Z

    .line 140
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mPrivateIcon:Landroid/widget/ImageView;

    const v1, 0x7f0201db

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 141
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mPrivateSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, v4}, Lco/vine/android/views/SwitchInterface;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 142
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mPrivateSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, v2}, Lco/vine/android/views/SwitchInterface;->setChecked(Z)V

    .line 143
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mPrivateSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, p0}, Lco/vine/android/views/SwitchInterface;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    goto :goto_0

    .line 133
    :pswitch_1
    iput-boolean v3, p0, Lco/vine/android/ContentControlsFragment;->mPrivate:Z

    .line 134
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mProgress:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 135
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ContentControlsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    invoke-virtual {v0, v1, v3}, Lco/vine/android/client/AppController;->updatePrivate(Lco/vine/android/client/Session;Z)Ljava/lang/String;

    goto :goto_0

    .line 150
    :pswitch_2
    packed-switch p3, :pswitch_data_2

    .line 158
    iput-boolean v2, p0, Lco/vine/android/ContentControlsFragment;->mPrivate:Z

    .line 159
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mPrivateIcon:Landroid/widget/ImageView;

    const v1, 0x7f0201dc

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 160
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mPrivateSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, v4}, Lco/vine/android/views/SwitchInterface;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 161
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mPrivateSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, v3}, Lco/vine/android/views/SwitchInterface;->setChecked(Z)V

    .line 162
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mPrivateSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, p0}, Lco/vine/android/views/SwitchInterface;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    goto :goto_0

    .line 152
    :pswitch_3
    iput-boolean v2, p0, Lco/vine/android/ContentControlsFragment;->mPrivate:Z

    .line 153
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mProgress:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 154
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ContentControlsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->updatePrivate(Lco/vine/android/client/Session;Z)Ljava/lang/String;

    goto :goto_0

    .line 168
    :pswitch_4
    packed-switch p3, :pswitch_data_3

    .line 176
    iput-boolean v2, p0, Lco/vine/android/ContentControlsFragment;->mExplicit:Z

    .line 177
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mExplicitIcon:Landroid/widget/ImageView;

    const v1, 0x7f0201d9

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 178
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mExplicitSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, v4}, Lco/vine/android/views/SwitchInterface;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 179
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mExplicitSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, v2}, Lco/vine/android/views/SwitchInterface;->setChecked(Z)V

    .line 180
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mExplicitSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, p0}, Lco/vine/android/views/SwitchInterface;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    goto :goto_0

    .line 170
    :pswitch_5
    iput-boolean v3, p0, Lco/vine/android/ContentControlsFragment;->mExplicit:Z

    .line 171
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mProgress:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 172
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ContentControlsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    invoke-virtual {v0, v1, v3}, Lco/vine/android/client/AppController;->updateExplicit(Lco/vine/android/client/Session;Z)Ljava/lang/String;

    goto/16 :goto_0

    .line 187
    :pswitch_6
    packed-switch p3, :pswitch_data_4

    .line 195
    iput-boolean v3, p0, Lco/vine/android/ContentControlsFragment;->mExplicit:Z

    .line 196
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mExplicitIcon:Landroid/widget/ImageView;

    const v1, 0x7f0201da

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 197
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mExplicitSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, v4}, Lco/vine/android/views/SwitchInterface;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 198
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mExplicitSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, v3}, Lco/vine/android/views/SwitchInterface;->setChecked(Z)V

    .line 199
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mExplicitSwitch:Lco/vine/android/views/SwitchInterface;

    invoke-interface {v0, p0}, Lco/vine/android/views/SwitchInterface;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    goto/16 :goto_0

    .line 189
    :pswitch_7
    iput-boolean v2, p0, Lco/vine/android/ContentControlsFragment;->mExplicit:Z

    .line 190
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mProgress:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 191
    iget-object v0, p0, Lco/vine/android/ContentControlsFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ContentControlsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->updateExplicit(Lco/vine/android/client/Session;Z)Ljava/lang/String;

    goto/16 :goto_0

    .line 129
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_4
        :pswitch_6
    .end packed-switch

    .line 131
    :pswitch_data_1
    .packed-switch -0x1
        :pswitch_1
    .end packed-switch

    .line 150
    :pswitch_data_2
    .packed-switch -0x1
        :pswitch_3
    .end packed-switch

    .line 168
    :pswitch_data_3
    .packed-switch -0x1
        :pswitch_5
    .end packed-switch

    .line 187
    :pswitch_data_4
    .packed-switch -0x1
        :pswitch_7
    .end packed-switch
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 68
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 69
    const-string v0, "state_private"

    iget-boolean v1, p0, Lco/vine/android/ContentControlsFragment;->mPrivate:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 70
    const-string v0, "state_explicit"

    iget-boolean v1, p0, Lco/vine/android/ContentControlsFragment;->mExplicit:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 71
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v5, 0x8

    const/4 v4, 0x1

    .line 95
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseControllerFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 96
    const v2, 0x7f0a008e

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lco/vine/android/views/SwitchInterface;

    .line 97
    .local v1, "pSwitch":Lco/vine/android/views/SwitchInterface;
    const v2, 0x7f0a0094

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lco/vine/android/views/SwitchInterface;

    .line 99
    .local v0, "eSwitch":Lco/vine/android/views/SwitchInterface;
    const v2, 0x7f0a008c

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lco/vine/android/ContentControlsFragment;->mPrivateIcon:Landroid/widget/ImageView;

    .line 100
    iget-boolean v2, p0, Lco/vine/android/ContentControlsFragment;->mPrivate:Z

    if-eqz v2, :cond_0

    .line 101
    iget-object v2, p0, Lco/vine/android/ContentControlsFragment;->mPrivateIcon:Landroid/widget/ImageView;

    const v3, 0x7f0201dc

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 102
    invoke-interface {v1, v4}, Lco/vine/android/views/SwitchInterface;->setChecked(Z)V

    .line 107
    :goto_0
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 108
    const v2, 0x7f0a0090

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/view/View;->setVisibility(I)V

    .line 109
    const v2, 0x7f0a0095

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/view/View;->setVisibility(I)V

    .line 120
    :goto_1
    invoke-interface {v1, p0}, Lco/vine/android/views/SwitchInterface;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 121
    invoke-interface {v0, p0}, Lco/vine/android/views/SwitchInterface;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 123
    iput-object v1, p0, Lco/vine/android/ContentControlsFragment;->mPrivateSwitch:Lco/vine/android/views/SwitchInterface;

    .line 124
    iput-object v0, p0, Lco/vine/android/ContentControlsFragment;->mExplicitSwitch:Lco/vine/android/views/SwitchInterface;

    .line 125
    return-void

    .line 104
    :cond_0
    iget-object v2, p0, Lco/vine/android/ContentControlsFragment;->mPrivateIcon:Landroid/widget/ImageView;

    const v3, 0x7f0201db

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 111
    :cond_1
    const v2, 0x7f0a0092

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p0, Lco/vine/android/ContentControlsFragment;->mExplicitIcon:Landroid/widget/ImageView;

    .line 112
    iget-boolean v2, p0, Lco/vine/android/ContentControlsFragment;->mExplicit:Z

    if-eqz v2, :cond_2

    .line 113
    iget-object v2, p0, Lco/vine/android/ContentControlsFragment;->mExplicitIcon:Landroid/widget/ImageView;

    const v3, 0x7f0201da

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 114
    invoke-interface {v0, v4}, Lco/vine/android/views/SwitchInterface;->setChecked(Z)V

    goto :goto_1

    .line 116
    :cond_2
    iget-object v2, p0, Lco/vine/android/ContentControlsFragment;->mExplicitIcon:Landroid/widget/ImageView;

    const v3, 0x7f0201d9

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1
.end method
