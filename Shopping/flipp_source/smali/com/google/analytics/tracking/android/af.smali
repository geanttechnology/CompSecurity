.class final Lcom/google/analytics/tracking/android/af;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Ljava/util/Map;

.field final synthetic b:Lcom/google/analytics/tracking/android/ae;


# direct methods
.method constructor <init>(Lcom/google/analytics/tracking/android/ae;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/google/analytics/tracking/android/af;->b:Lcom/google/analytics/tracking/android/ae;

    iput-object p2, p0, Lcom/google/analytics/tracking/android/af;->a:Ljava/util/Map;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 134
    iget-object v0, p0, Lcom/google/analytics/tracking/android/af;->a:Ljava/util/Map;

    const-string v1, "&cid"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/google/analytics/tracking/android/af;->a:Ljava/util/Map;

    const-string v1, "&cid"

    iget-object v2, p0, Lcom/google/analytics/tracking/android/af;->b:Lcom/google/analytics/tracking/android/ae;

    invoke-static {v2}, Lcom/google/analytics/tracking/android/ae;->a(Lcom/google/analytics/tracking/android/ae;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 143
    :cond_0
    iget-object v0, p0, Lcom/google/analytics/tracking/android/af;->b:Lcom/google/analytics/tracking/android/ae;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ae;->b(Lcom/google/analytics/tracking/android/ae;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ak;->a(Landroid/content/Context;)Lcom/google/analytics/tracking/android/ak;

    move-result-object v0

    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v1

    sget-object v2, Lcom/google/analytics/tracking/android/aj;->R:Lcom/google/analytics/tracking/android/aj;

    invoke-virtual {v1, v2}, Lcom/google/analytics/tracking/android/ai;->a(Lcom/google/analytics/tracking/android/aj;)V

    iget-object v0, v0, Lcom/google/analytics/tracking/android/ak;->a:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/google/analytics/tracking/android/af;->a:Ljava/util/Map;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ae;->b(Ljava/util/Map;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 159
    :cond_1
    :goto_0
    return-void

    .line 146
    :cond_2
    iget-object v0, p0, Lcom/google/analytics/tracking/android/af;->b:Lcom/google/analytics/tracking/android/ae;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ae;->c(Lcom/google/analytics/tracking/android/ae;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 147
    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v0

    invoke-virtual {v0, v5}, Lcom/google/analytics/tracking/android/ai;->a(Z)V

    .line 148
    iget-object v2, p0, Lcom/google/analytics/tracking/android/af;->a:Ljava/util/Map;

    new-instance v1, Lcom/google/analytics/tracking/android/aq;

    invoke-direct {v1}, Lcom/google/analytics/tracking/android/aq;-><init>()V

    iget-object v0, p0, Lcom/google/analytics/tracking/android/af;->b:Lcom/google/analytics/tracking/android/ae;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ae;->c(Lcom/google/analytics/tracking/android/ae;)Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v3

    sget-object v4, Lcom/google/analytics/tracking/android/aj;->d:Lcom/google/analytics/tracking/android/aj;

    invoke-virtual {v3, v4}, Lcom/google/analytics/tracking/android/ai;->a(Lcom/google/analytics/tracking/android/aj;)V

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ba;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_5

    move-object v0, v1

    :goto_1
    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/aq;->a()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 149
    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/google/analytics/tracking/android/ai;->a(Z)V

    .line 150
    iget-object v0, p0, Lcom/google/analytics/tracking/android/af;->b:Lcom/google/analytics/tracking/android/ae;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ae;->d(Lcom/google/analytics/tracking/android/ae;)Ljava/lang/String;

    .line 152
    :cond_3
    iget-object v0, p0, Lcom/google/analytics/tracking/android/af;->a:Ljava/util/Map;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ae;->c(Ljava/util/Map;)V

    .line 153
    iget-object v0, p0, Lcom/google/analytics/tracking/android/af;->a:Ljava/util/Map;

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_4
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const-string v4, "&"

    invoke-virtual {v2, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_4

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_4

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 148
    :cond_5
    invoke-static {v0}, Lcom/google/analytics/tracking/android/ba;->a(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v3

    const-string v4, "&cc"

    const-string v0, "utm_content"

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v4, v0}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v4, "&cm"

    const-string v0, "utm_medium"

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v4, v0}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v4, "&cn"

    const-string v0, "utm_campaign"

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v4, v0}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v4, "&cs"

    const-string v0, "utm_source"

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v4, v0}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v4, "&ck"

    const-string v0, "utm_term"

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v4, v0}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v4, "&ci"

    const-string v0, "utm_id"

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v4, v0}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v4, "&gclid"

    const-string v0, "gclid"

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v4, v0}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v4, "&dclid"

    const-string v0, "dclid"

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v4, v0}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v4, "&gmob_t"

    const-string v0, "gmob_t"

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1, v4, v0}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    move-object v0, v1

    goto/16 :goto_1

    .line 154
    :cond_6
    iget-object v0, p0, Lcom/google/analytics/tracking/android/af;->b:Lcom/google/analytics/tracking/android/ae;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ae;->f(Lcom/google/analytics/tracking/android/ae;)Lcom/google/analytics/tracking/android/aw;

    move-result-object v0

    iget-object v2, p0, Lcom/google/analytics/tracking/android/af;->a:Ljava/util/Map;

    const-string v3, "&ht"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    iget-object v4, p0, Lcom/google/analytics/tracking/android/af;->a:Ljava/util/Map;

    invoke-static {v4}, Lcom/google/analytics/tracking/android/ae;->d(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/google/analytics/tracking/android/af;->b:Lcom/google/analytics/tracking/android/ae;

    invoke-static {v5}, Lcom/google/analytics/tracking/android/ae;->e(Lcom/google/analytics/tracking/android/ae;)Ljava/util/List;

    move-result-object v5

    invoke-interface/range {v0 .. v5}, Lcom/google/analytics/tracking/android/aw;->a(Ljava/util/Map;JLjava/lang/String;Ljava/util/List;)V

    goto/16 :goto_0
.end method
