.class Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;
.super Ljava/lang/Object;
.source "SearchDebugView.java"

# interfaces
.implements Landroid/widget/RadioGroup$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SearchDebugOnCheckedChangeListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;->this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$1;

    .prologue
    .line 47
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;-><init>(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;)V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/RadioGroup;I)V
    .locals 5
    .param p1, "group"    # Landroid/widget/RadioGroup;
    .param p2, "checkedId"    # I

    .prologue
    .line 50
    sget v2, Lcom/amazon/retailsearch/R$id;->prod_env_selected:I

    if-ne p2, v2, :cond_1

    .line 51
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->getInstance()Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;

    move-result-object v2

    const-string/jumbo v3, "amazon"

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->setConfigurationId(Ljava/lang/String;)V

    .line 52
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;->this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    # getter for: Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->info:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->access$100(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;)Landroid/widget/TextView;

    move-result-object v2

    const-string/jumbo v3, ""

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 66
    :cond_0
    :goto_0
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v1

    .line 67
    .local v1, "searchConfig":Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealmForLocale(Ljava/util/Locale;)Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v0

    .line 68
    .local v0, "newRealm":Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    invoke-virtual {v1, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->setRealm(Lcom/amazon/searchapp/retailsearch/client/SearchRealm;)V

    .line 69
    invoke-static {}, Lcom/amazon/retailsearch/client/AndroidRetailSearchClient;->resetClient()V

    .line 70
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;->this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    # getter for: Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->envUrl:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->access$200(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;)Landroid/widget/TextView;

    move-result-object v2

    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getSecureSearchServiceUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 71
    return-void

    .line 53
    .end local v0    # "newRealm":Lcom/amazon/searchapp/retailsearch/client/SearchRealm;
    .end local v1    # "searchConfig":Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;
    :cond_1
    sget v2, Lcom/amazon/retailsearch/R$id;->gamma_env_selected:I

    if-ne p2, v2, :cond_2

    .line 54
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->getInstance()Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;

    move-result-object v2

    const-string/jumbo v3, "test1"

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->setConfigurationId(Ljava/lang/String;)V

    .line 55
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;->this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    # getter for: Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->info:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->access$100(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;)Landroid/widget/TextView;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;->this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$string;->rs_external_warning:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 56
    :cond_2
    sget v2, Lcom/amazon/retailsearch/R$id;->beta_env_selected:I

    if-ne p2, v2, :cond_3

    .line 57
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->getInstance()Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;

    move-result-object v2

    const-string/jumbo v3, "test2"

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->setConfigurationId(Ljava/lang/String;)V

    .line 58
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;->this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    # getter for: Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->info:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->access$100(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;)Landroid/widget/TextView;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;->this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$string;->rs_external_warning:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 59
    :cond_3
    sget v2, Lcom/amazon/retailsearch/R$id;->integ_beta_env_selected:I

    if-ne p2, v2, :cond_4

    .line 60
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->getInstance()Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;

    move-result-object v2

    const-string/jumbo v3, "test3"

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->setConfigurationId(Ljava/lang/String;)V

    .line 61
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;->this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    # getter for: Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->info:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->access$100(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;)Landroid/widget/TextView;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;->this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$string;->rs_ilaw_warning:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 62
    :cond_4
    sget v2, Lcom/amazon/retailsearch/R$id;->integ_gamma_env_selected:I

    if-ne p2, v2, :cond_0

    .line 63
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->getInstance()Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;

    move-result-object v2

    const-string/jumbo v3, "test4"

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchConfigurationManager;->setConfigurationId(Ljava/lang/String;)V

    .line 64
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;->this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    # getter for: Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->info:Landroid/widget/TextView;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->access$100(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;)Landroid/widget/TextView;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;->this$0:Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$string;->rs_ilaw_warning:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0
.end method
