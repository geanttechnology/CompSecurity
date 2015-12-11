.class public Lco/vine/android/widgets/PromptDialogFragment;
.super Landroid/app/DialogFragment;
.source "PromptDialogFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;
    }
.end annotation


# static fields
.field private static final ARG_DIALOG_ICON:Ljava/lang/String; = "icon"

.field private static final ARG_DIALOG_ID:Ljava/lang/String; = "id"

.field private static final ARG_DIALOG_ITEMS:Ljava/lang/String; = "items"

.field private static final ARG_DIALOG_ITEMS_STRING:Ljava/lang/String; = "items_string"

.field private static final ARG_DIALOG_MESSAGE:Ljava/lang/String; = "message"

.field private static final ARG_DIALOG_NEGATIVE_BUTTON:Ljava/lang/String; = "negative_button"

.field private static final ARG_DIALOG_NEUTRAL_BUTTON:Ljava/lang/String; = "neutral_button"

.field private static final ARG_DIALOG_POSITIVE_BUTTON:Ljava/lang/String; = "positive_button"

.field private static final ARG_DIALOG_TITLE:Ljava/lang/String; = "title"


# instance fields
.field private mListener:Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    .line 38
    return-void
.end method

.method public static newInstance(I)Lco/vine/android/widgets/PromptDialogFragment;
    .locals 3
    .param p0, "id"    # I

    .prologue
    .line 43
    new-instance v1, Lco/vine/android/widgets/PromptDialogFragment;

    invoke-direct {v1}, Lco/vine/android/widgets/PromptDialogFragment;-><init>()V

    .line 45
    .local v1, "f":Lco/vine/android/widgets/PromptDialogFragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 46
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v2, "id"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 47
    invoke-virtual {v1, v0}, Lco/vine/android/widgets/PromptDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 49
    return-object v1
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 54
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onAttach(Landroid/app/Activity;)V

    .line 56
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getTargetFragment()Landroid/app/Fragment;

    move-result-object v0

    .line 57
    .local v0, "targetFragment":Landroid/app/Fragment;
    if-eqz v0, :cond_1

    .line 58
    instance-of v1, v0, Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;

    if-eqz v1, :cond_0

    .line 59
    check-cast v0, Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;

    .end local v0    # "targetFragment":Landroid/app/Fragment;
    iput-object v0, p0, Lco/vine/android/widgets/PromptDialogFragment;->mListener:Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;

    .line 64
    .end local p1    # "activity":Landroid/app/Activity;
    :cond_0
    :goto_0
    return-void

    .line 61
    .restart local v0    # "targetFragment":Landroid/app/Fragment;
    .restart local p1    # "activity":Landroid/app/Activity;
    :cond_1
    instance-of v1, p1, Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;

    if-eqz v1, :cond_0

    .line 62
    check-cast p1, Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lco/vine/android/widgets/PromptDialogFragment;->mListener:Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;

    goto :goto_0
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 110
    iget-object v0, p0, Lco/vine/android/widgets/PromptDialogFragment;->mListener:Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Lco/vine/android/widgets/PromptDialogFragment;->mListener:Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;

    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "id"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, p1, v1, p2}, Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;->onDialogDone(Landroid/content/DialogInterface;II)V

    .line 113
    :cond_0
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 68
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;

    .line 70
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 71
    .local v0, "args":Landroid/os/Bundle;
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const/4 v3, 0x2

    invoke-direct {v1, v2, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;I)V

    .line 74
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    const-string v2, "icon"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 75
    const-string v2, "icon"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 78
    :cond_0
    const-string v2, "title"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 79
    const-string v2, "title"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 82
    :cond_1
    const-string v2, "message"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 83
    const-string v2, "message"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    .line 86
    :cond_2
    const-string v2, "positive_button"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 87
    const-string v2, "positive_button"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2, p0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 90
    :cond_3
    const-string v2, "neutral_button"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 91
    const-string v2, "neutral_button"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2, p0}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 94
    :cond_4
    const-string v2, "negative_button"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 95
    const-string v2, "negative_button"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-virtual {v1, v2, p0}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 98
    :cond_5
    const-string v2, "items"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 99
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const-string v3, "items"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getTextArray(I)[Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v1, v2, p0}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 102
    :cond_6
    const-string v2, "items_string"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 103
    const-string v2, "items_string"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, p0}, Landroid/app/AlertDialog$Builder;->setItems([Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 106
    :cond_7
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v2

    return-object v2
.end method

.method public setIcon(I)Lco/vine/android/widgets/PromptDialogFragment;
    .locals 2
    .param p1, "icon"    # I

    .prologue
    .line 120
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "icon"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 121
    return-object p0
.end method

.method public setItems(I)Lco/vine/android/widgets/PromptDialogFragment;
    .locals 2
    .param p1, "items"    # I

    .prologue
    .line 135
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "items"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 136
    return-object p0
.end method

.method public setItems([Ljava/lang/String;)Lco/vine/android/widgets/PromptDialogFragment;
    .locals 2
    .param p1, "items"    # [Ljava/lang/String;

    .prologue
    .line 140
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "items_string"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    .line 141
    return-object p0
.end method

.method public setListener(Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;

    .prologue
    .line 116
    iput-object p1, p0, Lco/vine/android/widgets/PromptDialogFragment;->mListener:Lco/vine/android/widgets/PromptDialogFragment$OnDialogDoneListener;

    .line 117
    return-void
.end method

.method public setMessage(I)Lco/vine/android/widgets/PromptDialogFragment;
    .locals 2
    .param p1, "message"    # I

    .prologue
    .line 130
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "message"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 131
    return-object p0
.end method

.method public setNegativeButton(I)Lco/vine/android/widgets/PromptDialogFragment;
    .locals 2
    .param p1, "negativeButton"    # I

    .prologue
    .line 155
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "negative_button"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 156
    return-object p0
.end method

.method public setNeutralButton(I)Lco/vine/android/widgets/PromptDialogFragment;
    .locals 2
    .param p1, "neutralButton"    # I

    .prologue
    .line 150
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "neutral_button"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 151
    return-object p0
.end method

.method public setPositiveButton(I)Lco/vine/android/widgets/PromptDialogFragment;
    .locals 2
    .param p1, "positiveButton"    # I

    .prologue
    .line 145
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "positive_button"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 146
    return-object p0
.end method

.method public setTitle(I)Lco/vine/android/widgets/PromptDialogFragment;
    .locals 2
    .param p1, "title"    # I

    .prologue
    .line 125
    invoke-virtual {p0}, Lco/vine/android/widgets/PromptDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "title"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 126
    return-object p0
.end method

.method public show(Landroid/app/FragmentManager;)V
    .locals 1
    .param p1, "fragmentManager"    # Landroid/app/FragmentManager;

    .prologue
    .line 160
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lco/vine/android/widgets/PromptDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 161
    return-void
.end method
