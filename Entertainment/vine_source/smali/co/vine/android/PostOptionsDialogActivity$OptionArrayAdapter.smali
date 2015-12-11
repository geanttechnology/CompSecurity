.class Lco/vine/android/PostOptionsDialogActivity$OptionArrayAdapter;
.super Landroid/widget/ArrayAdapter;
.source "PostOptionsDialogActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/PostOptionsDialogActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "OptionArrayAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lco/vine/android/PostOptionsDialogActivity$Option;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/PostOptionsDialogActivity;


# direct methods
.method public constructor <init>(Lco/vine/android/PostOptionsDialogActivity;Landroid/content/Context;I)V
    .locals 0
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "layout"    # I

    .prologue
    .line 421
    iput-object p1, p0, Lco/vine/android/PostOptionsDialogActivity$OptionArrayAdapter;->this$0:Lco/vine/android/PostOptionsDialogActivity;

    .line 422
    invoke-direct {p0, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 423
    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 427
    invoke-super {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 428
    .local v2, "v":Landroid/view/View;
    invoke-virtual {p0, p1}, Lco/vine/android/PostOptionsDialogActivity$OptionArrayAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/PostOptionsDialogActivity$Option;

    .line 429
    .local v0, "option":Lco/vine/android/PostOptionsDialogActivity$Option;
    const v3, 0x7f0a014c

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 430
    .local v1, "title":Landroid/widget/TextView;
    iget v3, v0, Lco/vine/android/PostOptionsDialogActivity$Option;->id:I

    const/4 v4, 0x7

    if-ne v3, v4, :cond_0

    .line 431
    iget-object v3, p0, Lco/vine/android/PostOptionsDialogActivity$OptionArrayAdapter;->this$0:Lco/vine/android/PostOptionsDialogActivity;

    invoke-virtual {v3}, Lco/vine/android/PostOptionsDialogActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090081

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 435
    :goto_0
    iget-object v3, v0, Lco/vine/android/PostOptionsDialogActivity$Option;->text:Ljava/lang/String;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 436
    iget v3, v0, Lco/vine/android/PostOptionsDialogActivity$Option;->id:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 437
    return-object v2

    .line 433
    :cond_0
    iget-object v3, p0, Lco/vine/android/PostOptionsDialogActivity$OptionArrayAdapter;->this$0:Lco/vine/android/PostOptionsDialogActivity;

    invoke-virtual {v3}, Lco/vine/android/PostOptionsDialogActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090078

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_0
.end method
