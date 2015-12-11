.class Lco/vine/android/ContactsRecipientPickerFragment$1;
.super Lco/vine/android/OnContactEntryClickedListener;
.source "ContactsRecipientPickerFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ContactsRecipientPickerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ContactsRecipientPickerFragment;


# direct methods
.method constructor <init>(Lco/vine/android/ContactsRecipientPickerFragment;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lco/vine/android/ContactsRecipientPickerFragment$1;->this$0:Lco/vine/android/ContactsRecipientPickerFragment;

    invoke-direct {p0}, Lco/vine/android/OnContactEntryClickedListener;-><init>()V

    return-void
.end method


# virtual methods
.method protected onContactEntryClicked(Lco/vine/android/ContactEntry;Lco/vine/android/api/VineRecipient;ILjava/lang/String;)V
    .locals 1
    .param p1, "entry"    # Lco/vine/android/ContactEntry;
    .param p2, "recipient"    # Lco/vine/android/api/VineRecipient;
    .param p3, "typeFlag"    # I
    .param p4, "value"    # Ljava/lang/String;

    .prologue
    .line 144
    iget-object v0, p0, Lco/vine/android/ContactsRecipientPickerFragment$1;->this$0:Lco/vine/android/ContactsRecipientPickerFragment;

    # invokes: Lco/vine/android/ContactsRecipientPickerFragment;->onContactEntryClicked(Lco/vine/android/ContactEntry;Lco/vine/android/api/VineRecipient;ILjava/lang/String;)V
    invoke-static {v0, p1, p2, p3, p4}, Lco/vine/android/ContactsRecipientPickerFragment;->access$200(Lco/vine/android/ContactsRecipientPickerFragment;Lco/vine/android/ContactEntry;Lco/vine/android/api/VineRecipient;ILjava/lang/String;)V

    .line 145
    return-void
.end method
