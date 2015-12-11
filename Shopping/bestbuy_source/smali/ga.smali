.class public Lga;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static a:Lgb;

.field private static b:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lfu;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lga;->b:Ljava/lang/String;

    .line 27
    sget-object v0, Lgb;->a:Lgb;

    sput-object v0, Lga;->a:Lgb;

    return-void
.end method

.method private static a(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;
    .locals 5

    .prologue
    .line 200
    invoke-static {}, Lga;->a()Lgb;

    move-result-object v0

    .line 201
    iget-object v0, v0, Lgb;->g:Ljava/lang/String;

    .line 202
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 203
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Content-type"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 204
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Accept"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 205
    new-instance v2, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;-><init>()V

    .line 206
    invoke-virtual {v2, p0}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setSkuId(Ljava/lang/String;)V

    .line 207
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setQuantity(I)V

    .line 208
    invoke-virtual {v2, p1}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setStoreId(Ljava/lang/String;)V

    .line 209
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    invoke-virtual {v3, v2}, Lgy;->a(Lgu;)Ljava/lang/String;

    move-result-object v2

    .line 210
    const/4 v3, 0x0

    const-string v4, "application/json"

    invoke-static {v0, v3, v1, v2, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    .line 211
    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v0

    .line 212
    invoke-static {v0}, Lga;->c(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    .line 213
    invoke-static {}, Lgt;->a()V

    .line 214
    return-object v0
.end method

.method private static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;
    .locals 5

    .prologue
    .line 120
    invoke-static {}, Lga;->a()Lgb;

    move-result-object v0

    .line 121
    iget-object v0, v0, Lgb;->g:Ljava/lang/String;

    .line 122
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 123
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Content-type"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 124
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Accept"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 125
    new-instance v2, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;-><init>()V

    .line 126
    invoke-virtual {v2, p0}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setSkuId(Ljava/lang/String;)V

    .line 127
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setQuantity(I)V

    .line 128
    invoke-virtual {v2, p1}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setSellerId(Ljava/lang/String;)V

    .line 129
    invoke-virtual {v2, p2}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setListingId(Ljava/lang/String;)V

    .line 130
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    invoke-virtual {v3, v2}, Lgy;->a(Lgu;)Ljava/lang/String;

    move-result-object v2

    .line 131
    const/4 v3, 0x0

    const-string v4, "application/json"

    invoke-static {v0, v3, v1, v2, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    .line 132
    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v0

    .line 133
    invoke-static {v0}, Lga;->c(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    .line 134
    invoke-static {}, Lgt;->a()V

    .line 135
    return-object v0
.end method

.method private static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;
    .locals 5

    .prologue
    .line 139
    invoke-static {}, Lga;->a()Lgb;

    move-result-object v0

    .line 140
    iget-object v0, v0, Lgb;->g:Ljava/lang/String;

    .line 141
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 142
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Content-type"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 143
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Accept"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 144
    new-instance v2, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;-><init>()V

    .line 145
    invoke-virtual {v2, p0}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setSkuId(Ljava/lang/String;)V

    .line 146
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setQuantity(I)V

    .line 147
    invoke-virtual {v2, p1}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setSellerId(Ljava/lang/String;)V

    .line 148
    invoke-virtual {v2, p2}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setListingId(Ljava/lang/String;)V

    .line 149
    invoke-virtual {v2, p3}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setStoreId(Ljava/lang/String;)V

    .line 150
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    invoke-virtual {v3, v2}, Lgy;->a(Lgu;)Ljava/lang/String;

    move-result-object v2

    .line 151
    const/4 v3, 0x0

    const-string v4, "application/json"

    invoke-static {v0, v3, v1, v2, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    .line 152
    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v0

    .line 153
    invoke-static {v0}, Lga;->c(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    .line 154
    invoke-static {}, Lgt;->a()V

    .line 155
    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;
    .locals 1

    .prologue
    .line 86
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 87
    invoke-static {p0, p1, p2}, Lga;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    .line 99
    :goto_0
    return-object v0

    .line 88
    :cond_0
    if-eqz p0, :cond_1

    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    if-eqz p3, :cond_1

    invoke-virtual {p3}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 89
    invoke-static {p0, p1, p2, p3}, Lga;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    goto :goto_0

    .line 90
    :cond_1
    if-eqz p0, :cond_2

    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    if-eqz p4, :cond_2

    invoke-virtual {p4}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    if-eqz p3, :cond_2

    invoke-virtual {p3}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 91
    invoke-static {p0, p4, p3}, Lga;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    goto :goto_0

    .line 92
    :cond_2
    if-eqz p0, :cond_3

    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    if-eqz p5, :cond_3

    invoke-virtual {p5}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    if-eqz p6, :cond_3

    invoke-virtual {p6}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    if-eqz p7, :cond_3

    invoke-virtual {p7}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 93
    invoke-static {p0, p5, p6, p7}, Lga;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    goto :goto_0

    .line 94
    :cond_3
    if-eqz p0, :cond_4

    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    if-eqz p3, :cond_4

    invoke-virtual {p3}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 95
    invoke-static {p0, p3}, Lga;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    goto :goto_0

    .line 96
    :cond_4
    if-eqz p0, :cond_5

    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 97
    invoke-static {p0}, Lga;->b(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    goto/16 :goto_0

    .line 99
    :cond_5
    const/4 v0, 0x0

    goto/16 :goto_0
.end method

.method public static a()Lgb;
    .locals 1

    .prologue
    .line 82
    sget-object v0, Lga;->a:Lgb;

    return-object v0
.end method

.method public static a(Lft;)V
    .locals 1

    .prologue
    .line 60
    sget-object v0, Lft;->a:Lft;

    if-ne p0, v0, :cond_0

    .line 61
    sget-object v0, Lgb;->a:Lgb;

    sput-object v0, Lga;->a:Lgb;

    .line 75
    :goto_0
    return-void

    .line 62
    :cond_0
    sget-object v0, Lft;->f:Lft;

    if-ne p0, v0, :cond_1

    .line 63
    sget-object v0, Lgb;->b:Lgb;

    sput-object v0, Lga;->a:Lgb;

    goto :goto_0

    .line 64
    :cond_1
    sget-object v0, Lft;->h:Lft;

    if-ne p0, v0, :cond_2

    .line 65
    sget-object v0, Lgb;->c:Lgb;

    sput-object v0, Lga;->a:Lgb;

    goto :goto_0

    .line 66
    :cond_2
    sget-object v0, Lft;->d:Lft;

    if-ne p0, v0, :cond_3

    .line 67
    sget-object v0, Lgb;->d:Lgb;

    sput-object v0, Lga;->a:Lgb;

    goto :goto_0

    .line 68
    :cond_3
    sget-object v0, Lft;->i:Lft;

    if-ne p0, v0, :cond_4

    .line 69
    sget-object v0, Lgb;->e:Lgb;

    sput-object v0, Lga;->a:Lgb;

    goto :goto_0

    .line 70
    :cond_4
    sget-object v0, Lft;->l:Lft;

    if-ne p0, v0, :cond_5

    .line 71
    sget-object v0, Lgb;->f:Lgb;

    sput-object v0, Lga;->a:Lgb;

    goto :goto_0

    .line 73
    :cond_5
    sget-object v0, Lgb;->a:Lgb;

    sput-object v0, Lga;->a:Lgb;

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 47
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lgb;->a(Ljava/lang/String;)Lgb;

    move-result-object v0

    .line 48
    iput-object p0, v0, Lgb;->g:Ljava/lang/String;

    .line 49
    return-void
.end method

.method private static b(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;
    .locals 5

    .prologue
    .line 103
    invoke-static {}, Lga;->a()Lgb;

    move-result-object v0

    .line 104
    iget-object v0, v0, Lgb;->g:Ljava/lang/String;

    .line 105
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 106
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Content-type"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 107
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Accept"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 108
    new-instance v2, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;-><init>()V

    .line 109
    invoke-virtual {v2, p0}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setSkuId(Ljava/lang/String;)V

    .line 110
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setQuantity(I)V

    .line 111
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    invoke-virtual {v3, v2}, Lgy;->a(Lgu;)Ljava/lang/String;

    move-result-object v2

    .line 112
    const/4 v3, 0x0

    const-string v4, "application/json"

    invoke-static {v0, v3, v1, v2, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    .line 113
    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v0

    .line 114
    invoke-static {v0}, Lga;->c(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    .line 115
    invoke-static {}, Lgt;->a()V

    .line 116
    return-object v0
.end method

.method private static b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;
    .locals 5

    .prologue
    .line 159
    invoke-static {}, Lga;->a()Lgb;

    move-result-object v0

    .line 160
    iget-object v0, v0, Lgb;->g:Ljava/lang/String;

    .line 161
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 162
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Content-type"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 163
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Accept"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 164
    new-instance v2, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;-><init>()V

    .line 165
    invoke-virtual {v2, p0}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setSkuId(Ljava/lang/String;)V

    .line 166
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setQuantity(I)V

    .line 167
    invoke-virtual {v2, p1}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setLpnId(Ljava/lang/String;)V

    .line 168
    invoke-virtual {v2, p2}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setStoreId(Ljava/lang/String;)V

    .line 169
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    invoke-virtual {v3, v2}, Lgy;->a(Lgu;)Ljava/lang/String;

    move-result-object v2

    .line 170
    const/4 v3, 0x0

    const-string v4, "application/json"

    invoke-static {v0, v3, v1, v2, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    .line 171
    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v0

    .line 172
    invoke-static {v0}, Lga;->c(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    .line 173
    invoke-static {}, Lgt;->a()V

    .line 174
    return-object v0
.end method

.method private static b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;
    .locals 5

    .prologue
    .line 178
    invoke-static {}, Lga;->a()Lgb;

    move-result-object v0

    .line 179
    iget-object v0, v0, Lgb;->g:Ljava/lang/String;

    .line 180
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 181
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Content-type"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 182
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "Accept"

    const-string v4, "application/json"

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 183
    new-instance v2, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;-><init>()V

    .line 184
    invoke-virtual {v2, p0}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setSkuId(Ljava/lang/String;)V

    .line 185
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setQuantity(I)V

    .line 186
    new-instance v3, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;

    invoke-direct {v3}, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;-><init>()V

    .line 187
    invoke-virtual {v3, p1}, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->setGiftListId(Ljava/lang/String;)V

    .line 188
    invoke-virtual {v3, p3}, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->setGiftListType(Ljava/lang/String;)V

    .line 189
    invoke-virtual {v3, p2}, Lcom/bestbuy/android/api/lib/models/cart/GiftItem;->setGiftListItemId(Ljava/lang/String;)V

    .line 190
    invoke-virtual {v2, v3}, Lcom/bestbuy/android/api/lib/models/cart/CartRequest;->setGiftItem(Lcom/bestbuy/android/api/lib/models/cart/GiftItem;)V

    .line 191
    new-instance v3, Lgy;

    invoke-direct {v3}, Lgy;-><init>()V

    invoke-virtual {v3, v2}, Lgy;->a(Lgu;)Ljava/lang/String;

    move-result-object v2

    .line 192
    const/4 v3, 0x0

    const-string v4, "application/json"

    invoke-static {v0, v3, v1, v2, v4}, Lgw;->a(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    .line 193
    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v0

    .line 194
    invoke-static {v0}, Lga;->c(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    move-result-object v0

    .line 195
    invoke-static {}, Lgt;->a()V

    .line 196
    return-object v0
.end method

.method private static c(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/cart/CartResponse;
    .locals 2

    .prologue
    .line 218
    new-instance v0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;-><init>()V

    .line 219
    new-instance v1, Lgy;

    invoke-direct {v1}, Lgy;-><init>()V

    .line 220
    invoke-virtual {v1, p0, v0}, Lgy;->a(Ljava/lang/String;Lgu;)Lgu;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/cart/CartResponse;

    .line 221
    return-object v0
.end method
