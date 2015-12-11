.class public Lcom/wishabi/flipp/content/FlyerInfo;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;


# instance fields
.field public final a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/bb;",
            ">;"
        }
    .end annotation
.end field

.field public final b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/bb;",
            ">;"
        }
    .end annotation
.end field

.field public c:Ljava/lang/String;

.field private d:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 60
    new-instance v0, Lcom/wishabi/flipp/content/k;

    invoke-direct {v0}, Lcom/wishabi/flipp/content/k;-><init>()V

    sput-object v0, Lcom/wishabi/flipp/content/FlyerInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/content/FlyerInfo;->a:Ljava/util/ArrayList;

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/content/FlyerInfo;->b:Ljava/util/ArrayList;

    return-void
.end method

.method public static a(Lorg/json/JSONObject;)Lcom/wishabi/flipp/content/FlyerInfo;
    .locals 7

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 30
    :try_start_0
    new-instance v0, Lcom/wishabi/flipp/content/FlyerInfo;

    invoke-direct {v0}, Lcom/wishabi/flipp/content/FlyerInfo;-><init>()V

    .line 31
    const-string v3, "select_stores"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 33
    if-eqz v4, :cond_1

    move v3, v2

    .line 34
    :goto_0
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-ge v3, v5, :cond_1

    .line 35
    invoke-virtual {v4, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    invoke-static {v5}, Lcom/wishabi/flipp/content/bb;->a(Lorg/json/JSONObject;)Lcom/wishabi/flipp/content/bb;

    move-result-object v5

    .line 36
    if-eqz v5, :cond_0

    iget-object v6, v0, Lcom/wishabi/flipp/content/FlyerInfo;->a:Ljava/util/ArrayList;

    invoke-virtual {v6, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 34
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 40
    :cond_1
    const-string v3, "nearby_stores"

    invoke-virtual {p0, v3}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 41
    if-eqz v3, :cond_3

    .line 42
    :goto_1
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-ge v2, v4, :cond_3

    .line 43
    invoke-virtual {v3, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    invoke-static {v4}, Lcom/wishabi/flipp/content/bb;->a(Lorg/json/JSONObject;)Lcom/wishabi/flipp/content/bb;

    move-result-object v4

    .line 44
    if-eqz v4, :cond_2

    iget-object v5, v0, Lcom/wishabi/flipp/content/FlyerInfo;->b:Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 42
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 48
    :cond_3
    const-string v2, "corrections_url"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    move-object v2, v1

    :goto_2
    iput-object v2, v0, Lcom/wishabi/flipp/content/FlyerInfo;->c:Ljava/lang/String;

    .line 51
    invoke-virtual {p0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/wishabi/flipp/content/FlyerInfo;->d:Ljava/lang/String;

    .line 57
    :goto_3
    return-object v0

    .line 48
    :cond_4
    const-string v2, "corrections_url"

    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_2

    .line 52
    :catch_0
    move-exception v0

    invoke-virtual {v0}, Lorg/json/JSONException;->toString()Ljava/lang/String;

    move-object v0, v1

    .line 54
    goto :goto_3
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 80
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyerInfo;->d:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 86
    iget-object v0, p0, Lcom/wishabi/flipp/content/FlyerInfo;->d:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 87
    :cond_0
    return-void
.end method
