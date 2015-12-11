.class Lco/vine/android/RecipientPickerActivity$1;
.super Ljava/lang/Object;
.source "RecipientPickerActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/RecipientPickerActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/RecipientPickerActivity;


# direct methods
.method constructor <init>(Lco/vine/android/RecipientPickerActivity;)V
    .locals 0

    .prologue
    .line 197
    iput-object p1, p0, Lco/vine/android/RecipientPickerActivity$1;->this$0:Lco/vine/android/RecipientPickerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 200
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity$1;->this$0:Lco/vine/android/RecipientPickerActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/RecipientPickerActivity;->setForceFullList(Z)V

    .line 201
    return-void
.end method
