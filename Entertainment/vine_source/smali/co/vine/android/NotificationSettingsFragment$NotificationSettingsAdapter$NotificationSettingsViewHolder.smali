.class Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter$NotificationSettingsViewHolder;
.super Ljava/lang/Object;
.source "NotificationSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "NotificationSettingsViewHolder"
.end annotation


# instance fields
.field header:Landroid/view/View;

.field headerText:Landroid/widget/TextView;

.field selectionIndicator:Landroid/view/View;

.field spinner:Landroid/widget/Spinner;

.field final synthetic this$1:Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter;

.field title:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter;Landroid/view/View;)V
    .locals 1
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 247
    iput-object p1, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter$NotificationSettingsViewHolder;->this$1:Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 248
    const v0, 0x7f0a005b

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter$NotificationSettingsViewHolder;->header:Landroid/view/View;

    .line 249
    const v0, 0x7f0a005c

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter$NotificationSettingsViewHolder;->headerText:Landroid/widget/TextView;

    .line 250
    const v0, 0x7f0a004a

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter$NotificationSettingsViewHolder;->title:Landroid/widget/TextView;

    .line 251
    const v0, 0x7f0a0149

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter$NotificationSettingsViewHolder;->spinner:Landroid/widget/Spinner;

    .line 252
    const v0, 0x7f0a0148

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter$NotificationSettingsViewHolder;->selectionIndicator:Landroid/view/View;

    .line 253
    return-void
.end method
