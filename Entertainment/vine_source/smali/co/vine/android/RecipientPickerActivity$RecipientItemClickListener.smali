.class public Lco/vine/android/RecipientPickerActivity$RecipientItemClickListener;
.super Ljava/lang/Object;
.source "RecipientPickerActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/RecipientPickerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "RecipientItemClickListener"
.end annotation


# instance fields
.field private final position:I

.field private final recipient:Lco/vine/android/api/VineRecipient;

.field final synthetic this$0:Lco/vine/android/RecipientPickerActivity;


# direct methods
.method public constructor <init>(Lco/vine/android/RecipientPickerActivity;Lco/vine/android/api/VineRecipient;I)V
    .locals 0
    .param p2, "recipient"    # Lco/vine/android/api/VineRecipient;
    .param p3, "position"    # I

    .prologue
    .line 568
    iput-object p1, p0, Lco/vine/android/RecipientPickerActivity$RecipientItemClickListener;->this$0:Lco/vine/android/RecipientPickerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 569
    iput-object p2, p0, Lco/vine/android/RecipientPickerActivity$RecipientItemClickListener;->recipient:Lco/vine/android/api/VineRecipient;

    .line 570
    iput p3, p0, Lco/vine/android/RecipientPickerActivity$RecipientItemClickListener;->position:I

    .line 571
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 575
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity$RecipientItemClickListener;->this$0:Lco/vine/android/RecipientPickerActivity;

    iget-object v1, p0, Lco/vine/android/RecipientPickerActivity$RecipientItemClickListener;->recipient:Lco/vine/android/api/VineRecipient;

    invoke-virtual {v0, v1}, Lco/vine/android/RecipientPickerActivity;->onItemClick(Lco/vine/android/api/VineRecipient;)V

    .line 576
    return-void
.end method
