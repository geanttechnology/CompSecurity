.class Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)V
    .locals 0

    .prologue
    .line 139
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 4

    .prologue
    const v3, 0x7f0b0047

    const v2, 0x7f0b0022

    .line 142
    if-eqz p2, :cond_0

    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)Landroid/widget/Switch;

    move-result-object v0

    const-string v1, "Yes"

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setText(Ljava/lang/CharSequence;)V

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->b(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;Z)Z

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)Landroid/widget/Switch;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setTextColor(I)V

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 153
    :goto_0
    return-void

    .line 148
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)Landroid/widget/Switch;

    move-result-object v0

    const-string v1, "No"

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setText(Ljava/lang/CharSequence;)V

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->b(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;Z)Z

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)Landroid/widget/Switch;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setTextColor(I)V

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$2;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    goto :goto_0
.end method
