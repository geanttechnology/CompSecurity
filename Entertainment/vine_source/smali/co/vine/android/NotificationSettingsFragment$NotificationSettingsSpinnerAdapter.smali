.class public Lco/vine/android/NotificationSettingsFragment$NotificationSettingsSpinnerAdapter;
.super Landroid/widget/BaseAdapter;
.source "NotificationSettingsFragment.java"

# interfaces
.implements Landroid/widget/SpinnerAdapter;
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/NotificationSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "NotificationSettingsSpinnerAdapter"
.end annotation


# instance fields
.field private mContext:Landroid/content/Context;

.field private mSetting:Lco/vine/android/api/VineNotificationSetting;

.field final synthetic this$0:Lco/vine/android/NotificationSettingsFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/NotificationSettingsFragment;Landroid/content/Context;Lco/vine/android/api/VineNotificationSetting;)V
    .locals 0
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "setting"    # Lco/vine/android/api/VineNotificationSetting;

    .prologue
    .line 263
    iput-object p1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsSpinnerAdapter;->this$0:Lco/vine/android/NotificationSettingsFragment;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 264
    iput-object p3, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsSpinnerAdapter;->mSetting:Lco/vine/android/api/VineNotificationSetting;

    .line 265
    iput-object p2, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsSpinnerAdapter;->mContext:Landroid/content/Context;

    .line 266
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsSpinnerAdapter;->mSetting:Lco/vine/android/api/VineNotificationSetting;

    iget-object v0, v0, Lco/vine/android/api/VineNotificationSetting;->choices:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 275
    iget-object v0, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsSpinnerAdapter;->mSetting:Lco/vine/android/api/VineNotificationSetting;

    iget-object v0, v0, Lco/vine/android/api/VineNotificationSetting;->choices:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 280
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;
    .annotation build Lorg/jetbrains/annotations/Nullable;
    .end annotation

    .prologue
    .line 286
    iget-object v3, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsSpinnerAdapter;->mSetting:Lco/vine/android/api/VineNotificationSetting;

    iget-object v3, v3, Lco/vine/android/api/VineNotificationSetting;->choices:Ljava/util/ArrayList;

    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/util/Pair;

    .line 288
    .local v0, "choice":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p2, :cond_0

    .line 289
    move-object v1, p2

    .line 293
    .local v1, "res":Landroid/view/View;
    :goto_0
    const v3, 0x7f0a004a

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 294
    .local v2, "t":Landroid/widget/TextView;
    iget-object v3, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v3, Ljava/lang/CharSequence;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 295
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setSingleLine(Z)V

    .line 296
    invoke-virtual {v1}, Landroid/view/View;->invalidate()V

    .line 297
    return-object v1

    .line 291
    .end local v1    # "res":Landroid/view/View;
    .end local v2    # "t":Landroid/widget/TextView;
    :cond_0
    iget-object v3, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsSpinnerAdapter;->mContext:Landroid/content/Context;

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    const v4, 0x7f030092

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .restart local v1    # "res":Landroid/view/View;
    goto :goto_0
.end method

.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 302
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsSpinnerAdapter;->mSetting:Lco/vine/android/api/VineNotificationSetting;

    iget-object v0, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsSpinnerAdapter;->mSetting:Lco/vine/android/api/VineNotificationSetting;

    iget-object v0, v0, Lco/vine/android/api/VineNotificationSetting;->choices:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/util/Pair;

    iget-object v0, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    iput-object v0, v1, Lco/vine/android/api/VineNotificationSetting;->value:Ljava/lang/String;

    .line 303
    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->setSelection(I)V

    .line 304
    return-void
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 308
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    return-void
.end method
