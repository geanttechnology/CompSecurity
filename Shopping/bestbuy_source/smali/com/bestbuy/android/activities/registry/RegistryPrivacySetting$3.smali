.class Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 156
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$3;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 159
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$3;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    const-string v1, "public"

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->a(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;Ljava/lang/String;)Ljava/lang/String;

    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$3;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->c(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;Z)Z

    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$3;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->d()V

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$3;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->f()V

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$3;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->b(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;Z)Z

    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting$3;->a:Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;->a(Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;Z)Z

    .line 165
    return-void
.end method
