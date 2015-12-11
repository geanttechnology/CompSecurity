.class public Lco/vine/android/widgets/PromptDialogSupportFragment;
.super Landroid/support/v4/app/DialogFragment;
.source "PromptDialogSupportFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;
    }
.end annotation


# static fields
.field private static final ARG_DIALOG_ICON:Ljava/lang/String; = "icon"

.field private static final ARG_DIALOG_ID:Ljava/lang/String; = "id"

.field private static final ARG_DIALOG_ITEMS:Ljava/lang/String; = "items"

.field private static final ARG_DIALOG_ITEMS_STRING:Ljava/lang/String; = "items_string"

.field private static final ARG_DIALOG_MESSAGE:Ljava/lang/String; = "message"

.field private static final ARG_DIALOG_MESSAGE_STRING:Ljava/lang/String; = "message_string"

.field private static final ARG_DIALOG_NEGATIVE_BUTTON:Ljava/lang/String; = "negative_button"

.field private static final ARG_DIALOG_NEUTRAL_BUTTON:Ljava/lang/String; = "neutral_button"

.field private static final ARG_DIALOG_POSITIVE_BUTTON:Ljava/lang/String; = "positive_button"

.field private static final ARG_DIALOG_THEME:Ljava/lang/String; = "theme"

.field private static final ARG_DIALOG_TITLE:Ljava/lang/String; = "title"


# instance fields
.field private mListener:Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    .line 41
    return-void
.end method

.method public static newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;
    .locals 1
    .param p0, "id"    # I

    .prologue
    .line 57
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(II)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v0

    return-object v0
.end method

.method public static newInstance(II)Lco/vine/android/widgets/PromptDialogSupportFragment;
    .locals 3
    .param p0, "id"    # I
    .param p1, "theme"    # I

    .prologue
    .line 46
    new-instance v1, Lco/vine/android/widgets/PromptDialogSupportFragment;

    invoke-direct {v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;-><init>()V

    .line 48
    .local v1, "f":Lco/vine/android/widgets/PromptDialogSupportFragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 49
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v2, "id"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 50
    const-string v2, "theme"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 51
    invoke-virtual {v1, v0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setArguments(Landroid/os/Bundle;)V

    .line 53
    return-object v1
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 62
    invoke-super {p0, p1}, Landroid/support/v4/app/DialogFragment;->onAttach(Landroid/app/Activity;)V

    .line 64
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 65
    .local v0, "targetFragment":Landroid/support/v4/app/Fragment;
    if-eqz v0, :cond_1

    .line 66
    instance-of v1, v0, Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;

    if-eqz v1, :cond_0

    .line 67
    check-cast v0, Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;

    .end local v0    # "targetFragment":Landroid/support/v4/app/Fragment;
    iput-object v0, p0, Lco/vine/android/widgets/PromptDialogSupportFragment;->mListener:Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;

    .line 72
    .end local p1    # "activity":Landroid/app/Activity;
    :cond_0
    :goto_0
    return-void

    .line 69
    .restart local v0    # "targetFragment":Landroid/support/v4/app/Fragment;
    .restart local p1    # "activity":Landroid/app/Activity;
    :cond_1
    instance-of v1, p1, Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;

    if-eqz v1, :cond_0

    .line 70
    check-cast p1, Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lco/vine/android/widgets/PromptDialogSupportFragment;->mListener:Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;

    goto :goto_0
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 127
    iget-object v0, p0, Lco/vine/android/widgets/PromptDialogSupportFragment;->mListener:Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;

    if-eqz v0, :cond_0

    .line 128
    iget-object v0, p0, Lco/vine/android/widgets/PromptDialogSupportFragment;->mListener:Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;

    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "id"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, p1, v1, p2}, Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;->onDialogDone(Landroid/content/DialogInterface;II)V

    .line 130
    :cond_0
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 77
    invoke-super {p0, p1}, Landroid/support/v4/app/DialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;

    .line 79
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 80
    .local v0, "args":Landroid/os/Bundle;
    const-string v3, "theme"

    const/4 v4, 0x2

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    .line 81
    .local v2, "theme":I
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xb

    if-lt v3, v4, :cond_9

    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v1, v3, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;I)V

    .line 87
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    :goto_0
    const-string v3, "icon"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 88
    const-string v3, "icon"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 91
    :cond_0
    const-string v3, "title"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 92
    const-string v3, "title"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 95
    :cond_1
    const-string v3, "message"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 96
    const-string v3, "message"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    .line 99
    :cond_2
    const-string v3, "message_string"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 100
    const-string v3, "message_string"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 103
    :cond_3
    const-string v3, "positive_button"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 104
    const-string v3, "positive_button"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v1, v3, p0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 107
    :cond_4
    const-string v3, "neutral_button"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 108
    const-string v3, "neutral_button"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v1, v3, p0}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 111
    :cond_5
    const-string v3, "negative_button"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 112
    const-string v3, "negative_button"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v1, v3, p0}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 115
    :cond_6
    const-string v3, "items"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 116
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const-string v4, "items"

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getTextArray(I)[Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v1, v3, p0}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 119
    :cond_7
    const-string v3, "items_string"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 120
    const-string v3, "items_string"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3, p0}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 123
    :cond_8
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v3

    return-object v3

    .line 81
    .end local v1    # "builder":Landroid/app/AlertDialog$Builder;
    :cond_9
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    goto/16 :goto_0
.end method

.method public setIcon(I)Lco/vine/android/widgets/PromptDialogSupportFragment;
    .locals 2
    .param p1, "icon"    # I

    .prologue
    .line 137
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "icon"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 138
    return-object p0
.end method

.method public setItems(I)Lco/vine/android/widgets/PromptDialogSupportFragment;
    .locals 2
    .param p1, "items"    # I

    .prologue
    .line 157
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "items"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 158
    return-object p0
.end method

.method public setItems([Ljava/lang/String;)Lco/vine/android/widgets/PromptDialogSupportFragment;
    .locals 2
    .param p1, "items"    # [Ljava/lang/String;

    .prologue
    .line 162
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "items_string"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    .line 163
    return-object p0
.end method

.method public setListener(Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;

    .prologue
    .line 133
    iput-object p1, p0, Lco/vine/android/widgets/PromptDialogSupportFragment;->mListener:Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;

    .line 134
    return-void
.end method

.method public setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;
    .locals 2
    .param p1, "message"    # I

    .prologue
    .line 147
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "message"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 148
    return-object p0
.end method

.method public setMessage(Ljava/lang/String;)Lco/vine/android/widgets/PromptDialogSupportFragment;
    .locals 2
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 152
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "message_string"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 153
    return-object p0
.end method

.method public setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;
    .locals 2
    .param p1, "negativeButton"    # I

    .prologue
    .line 177
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "negative_button"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 178
    return-object p0
.end method

.method public setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;
    .locals 2
    .param p1, "neutralButton"    # I

    .prologue
    .line 172
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "neutral_button"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 173
    return-object p0
.end method

.method public setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;
    .locals 2
    .param p1, "positiveButton"    # I

    .prologue
    .line 167
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "positive_button"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 168
    return-object p0
.end method

.method public setTitle(I)Lco/vine/android/widgets/PromptDialogSupportFragment;
    .locals 2
    .param p1, "title"    # I

    .prologue
    .line 142
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "title"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 143
    return-object p0
.end method

.method public show(Landroid/support/v4/app/FragmentManager;)V
    .locals 1
    .param p1, "fragmentManager"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    .line 182
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 183
    return-void
.end method
