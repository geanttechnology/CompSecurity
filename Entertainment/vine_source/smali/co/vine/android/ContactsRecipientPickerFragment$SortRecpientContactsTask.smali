.class Lco/vine/android/ContactsRecipientPickerFragment$SortRecpientContactsTask;
.super Lco/vine/android/SortContactsTask;
.source "ContactsRecipientPickerFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ContactsRecipientPickerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SortRecpientContactsTask"
.end annotation


# instance fields
.field private mId:I

.field final synthetic this$0:Lco/vine/android/ContactsRecipientPickerFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/ContactsRecipientPickerFragment;I)V
    .locals 0
    .param p2, "id"    # I

    .prologue
    .line 108
    iput-object p1, p0, Lco/vine/android/ContactsRecipientPickerFragment$SortRecpientContactsTask;->this$0:Lco/vine/android/ContactsRecipientPickerFragment;

    invoke-direct {p0}, Lco/vine/android/SortContactsTask;-><init>()V

    .line 109
    iput p2, p0, Lco/vine/android/ContactsRecipientPickerFragment$SortRecpientContactsTask;->mId:I

    .line 110
    return-void
.end method


# virtual methods
.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 104
    check-cast p1, Ljava/util/ArrayList;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lco/vine/android/ContactsRecipientPickerFragment$SortRecpientContactsTask;->onPostExecute(Ljava/util/ArrayList;)V

    return-void
.end method

.method protected onPostExecute(Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/ContactEntry;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 135
    .local p1, "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/ContactEntry;>;"
    iget-object v0, p0, Lco/vine/android/ContactsRecipientPickerFragment$SortRecpientContactsTask;->this$0:Lco/vine/android/ContactsRecipientPickerFragment;

    # getter for: Lco/vine/android/ContactsRecipientPickerFragment;->mActiveAdapter:Lco/vine/android/ContactsPickerAdapter;
    invoke-static {v0}, Lco/vine/android/ContactsRecipientPickerFragment;->access$100(Lco/vine/android/ContactsRecipientPickerFragment;)Lco/vine/android/ContactsPickerAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/ContactsPickerAdapter;->clear()V

    .line 136
    iget-object v0, p0, Lco/vine/android/ContactsRecipientPickerFragment$SortRecpientContactsTask;->this$0:Lco/vine/android/ContactsRecipientPickerFragment;

    # getter for: Lco/vine/android/ContactsRecipientPickerFragment;->mActiveAdapter:Lco/vine/android/ContactsPickerAdapter;
    invoke-static {v0}, Lco/vine/android/ContactsRecipientPickerFragment;->access$100(Lco/vine/android/ContactsRecipientPickerFragment;)Lco/vine/android/ContactsPickerAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lco/vine/android/ContactsPickerAdapter;->addAll(Ljava/util/Collection;)V

    .line 137
    iget-object v0, p0, Lco/vine/android/ContactsRecipientPickerFragment$SortRecpientContactsTask;->this$0:Lco/vine/android/ContactsRecipientPickerFragment;

    iget-object v0, v0, Lco/vine/android/ContactsRecipientPickerFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lco/vine/android/ContactsRecipientPickerFragment$SortRecpientContactsTask;->this$0:Lco/vine/android/ContactsRecipientPickerFragment;

    # getter for: Lco/vine/android/ContactsRecipientPickerFragment;->mActiveAdapter:Lco/vine/android/ContactsPickerAdapter;
    invoke-static {v1}, Lco/vine/android/ContactsRecipientPickerFragment;->access$100(Lco/vine/android/ContactsRecipientPickerFragment;)Lco/vine/android/ContactsPickerAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 138
    return-void
.end method

.method protected prepareEntries(Landroid/database/Cursor;)Ljava/util/ArrayList;
    .locals 6
    .param p1, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/Cursor;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/ContactEntry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 115
    iget v3, p0, Lco/vine/android/ContactsRecipientPickerFragment$SortRecpientContactsTask;->mId:I

    if-nez v3, :cond_0

    .line 116
    invoke-super {p0, p1}, Lco/vine/android/SortContactsTask;->prepareEntries(Landroid/database/Cursor;)Ljava/util/ArrayList;

    move-result-object v0

    .line 117
    .local v0, "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/ContactEntry;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/ContactEntry;

    .line 118
    .local v1, "entry":Lco/vine/android/ContactEntry;
    iget-object v3, p0, Lco/vine/android/ContactsRecipientPickerFragment$SortRecpientContactsTask;->this$0:Lco/vine/android/ContactsRecipientPickerFragment;

    # getter for: Lco/vine/android/ContactsRecipientPickerFragment;->mContactEntryMap:Ljava/util/HashMap;
    invoke-static {v3}, Lco/vine/android/ContactsRecipientPickerFragment;->access$000(Lco/vine/android/ContactsRecipientPickerFragment;)Ljava/util/HashMap;

    move-result-object v3

    iget-wide v4, v1, Lco/vine/android/ContactEntry;->contactId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 121
    .end local v0    # "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/ContactEntry;>;"
    .end local v1    # "entry":Lco/vine/android/ContactEntry;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 122
    .restart local v0    # "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/ContactEntry;>;"
    :cond_1
    :goto_1
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 123
    iget-object v3, p0, Lco/vine/android/ContactsRecipientPickerFragment$SortRecpientContactsTask;->this$0:Lco/vine/android/ContactsRecipientPickerFragment;

    # getter for: Lco/vine/android/ContactsRecipientPickerFragment;->mContactEntryMap:Ljava/util/HashMap;
    invoke-static {v3}, Lco/vine/android/ContactsRecipientPickerFragment;->access$000(Lco/vine/android/ContactsRecipientPickerFragment;)Ljava/util/HashMap;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/ContactEntry;

    .line 124
    .restart local v1    # "entry":Lco/vine/android/ContactEntry;
    if-eqz v1, :cond_1

    .line 125
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 128
    .end local v1    # "entry":Lco/vine/android/ContactEntry;
    :cond_2
    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 130
    :cond_3
    return-object v0
.end method
