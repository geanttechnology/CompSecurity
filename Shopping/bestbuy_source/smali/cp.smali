.class public Lcp;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/registry/ListTypes;",
        ">;"
    }
.end annotation


# instance fields
.field a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/ListTypes;",
            ">;"
        }
    .end annotation
.end field

.field b:Landroid/app/Activity;


# direct methods
.method public constructor <init>(Landroid/app/Activity;ILjava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/ListTypes;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 26
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 27
    iput-object p1, p0, Lcp;->b:Landroid/app/Activity;

    .line 28
    iput-object p3, p0, Lcp;->a:Ljava/util/ArrayList;

    .line 29
    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3

    .prologue
    .line 34
    if-nez p2, :cond_0

    .line 35
    iget-object v0, p0, Lcp;->b:Landroid/app/Activity;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 36
    const v1, 0x7f030116

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p3, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 37
    new-instance v1, Lcq;

    invoke-direct {v1}, Lcq;-><init>()V

    .line 38
    const v0, 0x7f0c040d

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcq;->a:Landroid/widget/TextView;

    .line 39
    const v0, 0x7f0c040c

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcq;->b:Landroid/widget/ImageView;

    .line 40
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 45
    :goto_0
    iget-object v2, v1, Lcq;->a:Landroid/widget/TextView;

    iget-object v0, p0, Lcp;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 47
    iget-object v0, p0, Lcp;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    const-string v2, "Back To School"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 48
    iget-object v0, v1, Lcq;->b:Landroid/widget/ImageView;

    const v1, 0x7f020017

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 64
    :goto_1
    return-object p2

    .line 43
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcq;

    move-object v1, v0

    goto :goto_0

    .line 49
    :cond_1
    iget-object v0, p0, Lcp;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    const-string v2, "Holiday"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 50
    iget-object v0, v1, Lcq;->b:Landroid/widget/ImageView;

    const v1, 0x7f0200e4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 51
    :cond_2
    iget-object v0, p0, Lcp;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    const-string v2, "Birthday"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 52
    iget-object v0, v1, Lcq;->b:Landroid/widget/ImageView;

    const v1, 0x7f020044

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 53
    :cond_3
    iget-object v0, p0, Lcp;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    const-string v2, "Anniversary"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 54
    iget-object v0, v1, Lcq;->b:Landroid/widget/ImageView;

    const v1, 0x7f02000c

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 55
    :cond_4
    iget-object v0, p0, Lcp;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    const-string v2, "Graduation"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 56
    iget-object v0, v1, Lcq;->b:Landroid/widget/ImageView;

    const v1, 0x7f0200df

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 57
    :cond_5
    iget-object v0, p0, Lcp;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    const-string v2, "Moving"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 58
    iget-object v0, v1, Lcq;->b:Landroid/widget/ImageView;

    const v1, 0x7f02011a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1

    .line 59
    :cond_6
    iget-object v0, p0, Lcp;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    const-string v2, "Wedding"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 60
    iget-object v0, v1, Lcq;->b:Landroid/widget/ImageView;

    const v1, 0x7f0201b7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1

    .line 62
    :cond_7
    iget-object v0, v1, Lcq;->b:Landroid/widget/ImageView;

    const v1, 0x7f0200ab

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1
.end method
