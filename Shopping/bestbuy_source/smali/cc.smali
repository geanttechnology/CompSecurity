.class public Lcc;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 170
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lcom/bestbuy/android/activities/home/DODHomeCard$1;)V
    .locals 0

    .prologue
    .line 170
    invoke-direct {p0}, Lcc;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;)I
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 173
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->getWidgetType()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->getWidgetType()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 174
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->getWidgetType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "feature"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->getWidgetType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->getWidgetType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 175
    const/4 v0, -0x1

    .line 184
    :cond_0
    :goto_0
    return v0

    .line 176
    :cond_1
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->getWidgetType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "feature"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->getWidgetType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->getWidgetType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 178
    :cond_2
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->getWidgetType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "feature"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;->getWidgetType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "feature"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 179
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 170
    check-cast p1, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;

    check-cast p2, Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;

    invoke-virtual {p0, p1, p2}, Lcc;->a(Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;Lcom/bestbuy/android/api/lib/models/home/GroupedDeal;)I

    move-result v0

    return v0
.end method
