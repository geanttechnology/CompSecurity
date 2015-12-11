.class public abstract Lco/vine/android/OnContactEntryClickedListener;
.super Ljava/lang/Object;
.source "OnContactEntryClickedListener.java"

# interfaces
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# static fields
.field public static final DIALOG_SELECT_CONTACT_ITEM:I


# instance fields
.field protected mEntry:Lco/vine/android/ContactEntry;

.field protected mValues:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/support/v4/app/Fragment;Lco/vine/android/ContactEntry;)V
    .locals 4
    .param p1, "fragment"    # Landroid/support/v4/app/Fragment;
    .param p2, "entry"    # Lco/vine/android/ContactEntry;

    .prologue
    const/4 v3, 0x0

    .line 21
    if-eqz p2, :cond_0

    .line 22
    iget-object v2, p2, Lco/vine/android/ContactEntry;->valueMimeMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 23
    .local v0, "keySet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v2

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {v0, v2}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    iput-object v2, p0, Lco/vine/android/OnContactEntryClickedListener;->mValues:[Ljava/lang/String;

    .line 24
    iput-object p2, p0, Lco/vine/android/OnContactEntryClickedListener;->mEntry:Lco/vine/android/ContactEntry;

    .line 25
    invoke-static {v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v1

    .line 27
    .local v1, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    iget-object v2, p0, Lco/vine/android/OnContactEntryClickedListener;->mValues:[Ljava/lang/String;

    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setItems([Ljava/lang/String;)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 28
    invoke-virtual {v1, p1, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 29
    invoke-virtual {v1, p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setListener(Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;)V

    .line 30
    invoke-virtual {p1}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    .line 32
    .end local v0    # "keySet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v1    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_0
    return-void
.end method

.method protected abstract onContactEntryClicked(Lco/vine/android/ContactEntry;Lco/vine/android/api/VineRecipient;ILjava/lang/String;)V
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 8
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    const-wide/16 v4, 0x0

    const-wide/16 v1, -0x1

    .line 38
    iget-object v0, p0, Lco/vine/android/OnContactEntryClickedListener;->mEntry:Lco/vine/android/ContactEntry;

    iget-object v0, v0, Lco/vine/android/ContactEntry;->valueMimeMap:Ljava/util/HashMap;

    iget-object v3, p0, Lco/vine/android/OnContactEntryClickedListener;->mValues:[Ljava/lang/String;

    aget-object v3, v3, p3

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Integer;

    .line 39
    .local v7, "typeFlag":Ljava/lang/Integer;
    if-eqz v7, :cond_2

    .line 40
    const/4 v6, 0x0

    .line 41
    .local v6, "recipient":Lco/vine/android/api/VineRecipient;
    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v3, 0x1

    if-ne v0, v3, :cond_0

    .line 42
    iget-object v0, p0, Lco/vine/android/OnContactEntryClickedListener;->mEntry:Lco/vine/android/ContactEntry;

    iget-object v0, v0, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    iget-object v3, p0, Lco/vine/android/OnContactEntryClickedListener;->mValues:[Ljava/lang/String;

    aget-object v3, v3, p3

    invoke-static/range {v0 .. v5}, Lco/vine/android/api/VineRecipient;->fromEmail(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;

    move-result-object v6

    .line 44
    :cond_0
    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v3, 0x2

    if-ne v0, v3, :cond_1

    .line 45
    iget-object v0, p0, Lco/vine/android/OnContactEntryClickedListener;->mEntry:Lco/vine/android/ContactEntry;

    iget-object v0, v0, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    iget-object v3, p0, Lco/vine/android/OnContactEntryClickedListener;->mValues:[Ljava/lang/String;

    aget-object v3, v3, p3

    invoke-static/range {v0 .. v5}, Lco/vine/android/api/VineRecipient;->fromPhone(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;

    move-result-object v6

    .line 47
    :cond_1
    if-eqz v6, :cond_2

    .line 48
    iget-object v0, p0, Lco/vine/android/OnContactEntryClickedListener;->mEntry:Lco/vine/android/ContactEntry;

    iget-wide v0, v0, Lco/vine/android/ContactEntry;->contactId:J

    iput-wide v0, v6, Lco/vine/android/api/VineRecipient;->contactId:J

    .line 49
    iget-object v0, p0, Lco/vine/android/OnContactEntryClickedListener;->mEntry:Lco/vine/android/ContactEntry;

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iget-object v2, p0, Lco/vine/android/OnContactEntryClickedListener;->mValues:[Ljava/lang/String;

    aget-object v2, v2, p3

    invoke-virtual {p0, v0, v6, v1, v2}, Lco/vine/android/OnContactEntryClickedListener;->onContactEntryClicked(Lco/vine/android/ContactEntry;Lco/vine/android/api/VineRecipient;ILjava/lang/String;)V

    .line 52
    .end local v6    # "recipient":Lco/vine/android/api/VineRecipient;
    :cond_2
    return-void
.end method
