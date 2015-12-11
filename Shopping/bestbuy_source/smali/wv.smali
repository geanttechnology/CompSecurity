.class public Lwv;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# static fields
.field static final a:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private b:I

.field private c:I

.field private d:I

.field private e:I

.field private f:Z

.field private g:Ljava/lang/String;

.field private final h:Lcom/google/android/gms/internal/gu;

.field private final i:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final j:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    new-instance v0, Ljava/util/HashSet;

    const/4 v1, 0x7

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "top-left"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "top-right"

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "top-center"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    const-string v3, "center"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "bottom-left"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "bottom-right"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "bottom-center"

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    sput-object v0, Lwv;->a:Ljava/util/Set;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/gu;Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/gu;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const/4 v1, 0x0

    const/4 v0, -0x1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput v0, p0, Lwv;->b:I

    iput v0, p0, Lwv;->c:I

    iput v1, p0, Lwv;->d:I

    iput v1, p0, Lwv;->e:I

    const/4 v0, 0x1

    iput-boolean v0, p0, Lwv;->f:Z

    const-string v0, "top-right"

    iput-object v0, p0, Lwv;->g:Ljava/lang/String;

    iput-object p1, p0, Lwv;->h:Lcom/google/android/gms/internal/gu;

    iput-object p2, p0, Lwv;->i:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/google/android/gms/internal/gu;->k()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lwv;->j:Landroid/content/Context;

    return-void
.end method

.method private e()V
    .locals 3

    iget-object v0, p0, Lwv;->j:Landroid/content/Context;

    invoke-static {v0}, Labq;->d(Landroid/content/Context;)[I

    move-result-object v1

    iget-object v0, p0, Lwv;->i:Ljava/util/Map;

    const-string v2, "width"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lwv;->i:Ljava/util/Map;

    const-string v2, "width"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Labq;->b(Ljava/lang/String;)I

    move-result v0

    const/4 v2, 0x0

    aget v2, v1, v2

    invoke-virtual {p0, v0, v2}, Lwv;->a(II)Z

    move-result v2

    if-eqz v2, :cond_0

    iput v0, p0, Lwv;->b:I

    :cond_0
    iget-object v0, p0, Lwv;->i:Ljava/util/Map;

    const-string v2, "height"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lwv;->i:Ljava/util/Map;

    const-string v2, "height"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Labq;->b(Ljava/lang/String;)I

    move-result v0

    const/4 v2, 0x1

    aget v1, v1, v2

    invoke-virtual {p0, v0, v1}, Lwv;->b(II)Z

    move-result v1

    if-eqz v1, :cond_1

    iput v0, p0, Lwv;->c:I

    :cond_1
    iget-object v0, p0, Lwv;->i:Ljava/util/Map;

    const-string v1, "offsetX"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lwv;->i:Ljava/util/Map;

    const-string v1, "offsetX"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Labq;->b(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lwv;->d:I

    :cond_2
    iget-object v0, p0, Lwv;->i:Ljava/util/Map;

    const-string v1, "offsetY"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lwv;->i:Ljava/util/Map;

    const-string v1, "offsetY"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Labq;->b(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lwv;->e:I

    :cond_3
    iget-object v0, p0, Lwv;->i:Ljava/util/Map;

    const-string v1, "allowOffscreen"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lwv;->i:Ljava/util/Map;

    const-string v1, "allowOffscreen"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lwv;->f:Z

    :cond_4
    iget-object v0, p0, Lwv;->i:Ljava/util/Map;

    const-string v1, "customClosePosition"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_5

    sget-object v1, Lwv;->a:Ljava/util/Set;

    invoke-interface {v1, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    iput-object v0, p0, Lwv;->g:Ljava/lang/String;

    :cond_5
    return-void
.end method


# virtual methods
.method a()Z
    .locals 2

    const/4 v1, -0x1

    iget v0, p0, Lwv;->b:I

    if-le v0, v1, :cond_0

    iget v0, p0, Lwv;->c:I

    if-le v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method a(II)Z
    .locals 1

    const/16 v0, 0x32

    if-lt p1, v0, :cond_0

    if-ge p1, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b()V
    .locals 7

    const/4 v6, -0x1

    const/4 v1, 0x0

    const-string v0, "PLEASE IMPLEMENT mraid.resize()"

    invoke-static {v0}, Lacb;->c(Ljava/lang/String;)V

    iget-object v0, p0, Lwv;->j:Landroid/content/Context;

    if-nez v0, :cond_0

    const-string v0, "Not an activity context. Cannot resize."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lwv;->h:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->e()Lcom/google/android/gms/internal/ay;

    move-result-object v0

    iget-boolean v0, v0, Lcom/google/android/gms/internal/ay;->e:Z

    if-eqz v0, :cond_1

    const-string v0, "Is interstitial. Cannot resize an interstitial."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lwv;->h:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->j()Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "Is expanded. Cannot resize an expanded banner."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    invoke-direct {p0}, Lwv;->e()V

    invoke-virtual {p0}, Lwv;->a()Z

    move-result v0

    if-nez v0, :cond_3

    const-string v0, "Invalid width and height options. Cannot resize."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lwv;->j:Landroid/content/Context;

    const-string v2, "window"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    new-instance v2, Landroid/util/DisplayMetrics;

    invoke-direct {v2}, Landroid/util/DisplayMetrics;-><init>()V

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    iget v0, p0, Lwv;->b:I

    invoke-static {v2, v0}, Laca;->a(Landroid/util/DisplayMetrics;I)I

    move-result v0

    add-int/lit8 v3, v0, 0x10

    iget v0, p0, Lwv;->c:I

    invoke-static {v2, v0}, Laca;->a(Landroid/util/DisplayMetrics;I)I

    move-result v0

    add-int/lit8 v2, v0, 0x10

    iget-object v0, p0, Lwv;->h:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/gu;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_4

    instance-of v4, v0, Landroid/view/ViewGroup;

    if-eqz v4, :cond_4

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v4, p0, Lwv;->h:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v0, v4}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    :cond_4
    new-instance v4, Landroid/widget/LinearLayout;

    iget-object v0, p0, Lwv;->j:Landroid/content/Context;

    invoke-direct {v4, v0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    invoke-virtual {v4, v1}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    new-instance v5, Landroid/widget/PopupWindow;

    iget-object v0, p0, Lwv;->j:Landroid/content/Context;

    invoke-direct {v5, v0}, Landroid/widget/PopupWindow;-><init>(Landroid/content/Context;)V

    invoke-virtual {v5, v2}, Landroid/widget/PopupWindow;->setHeight(I)V

    invoke-virtual {v5, v3}, Landroid/widget/PopupWindow;->setWidth(I)V

    iget-boolean v0, p0, Lwv;->f:Z

    if-nez v0, :cond_5

    const/4 v0, 0x1

    :goto_1
    invoke-virtual {v5, v0}, Landroid/widget/PopupWindow;->setClippingEnabled(Z)V

    invoke-virtual {v5, v4}, Landroid/widget/PopupWindow;->setContentView(Landroid/view/View;)V

    iget-object v0, p0, Lwv;->h:Lcom/google/android/gms/internal/gu;

    invoke-virtual {v4, v0, v6, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;II)V

    iget-object v0, p0, Lwv;->j:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    iget v2, p0, Lwv;->d:I

    iget v3, p0, Lwv;->e:I

    invoke-virtual {v5, v0, v1, v2, v3}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    iget-object v0, p0, Lwv;->h:Lcom/google/android/gms/internal/gu;

    new-instance v1, Lcom/google/android/gms/internal/ay;

    iget-object v2, p0, Lwv;->j:Landroid/content/Context;

    new-instance v3, Loo;

    iget v4, p0, Lwv;->b:I

    iget v5, p0, Lwv;->c:I

    invoke-direct {v3, v4, v5}, Loo;-><init>(II)V

    invoke-direct {v1, v2, v3}, Lcom/google/android/gms/internal/ay;-><init>(Landroid/content/Context;Loo;)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/internal/gu;->a(Lcom/google/android/gms/internal/ay;)V

    invoke-virtual {p0}, Lwv;->c()V

    invoke-virtual {p0}, Lwv;->d()V

    goto/16 :goto_0

    :cond_5
    move v0, v1

    goto :goto_1
.end method

.method b(II)Z
    .locals 1

    const/16 v0, 0x32

    if-lt p1, v0, :cond_0

    if-ge p1, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method c()V
    .locals 3

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    const-string v1, "x"

    iget v2, p0, Lwv;->d:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "y"

    iget v2, p0, Lwv;->e:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "width"

    iget v2, p0, Lwv;->b:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "height"

    iget v2, p0, Lwv;->c:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    move-result-object v0

    iget-object v1, p0, Lwv;->h:Lcom/google/android/gms/internal/gu;

    const-string v2, "onSizeChanged"

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gms/internal/gu;->b(Ljava/lang/String;Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Error occured while dispatching size change."

    invoke-static {v1, v0}, Lacb;->b(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method d()V
    .locals 3

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    const-string v1, "state"

    const-string v2, "resized"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v0

    iget-object v1, p0, Lwv;->h:Lcom/google/android/gms/internal/gu;

    const-string v2, "onStateChanged"

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gms/internal/gu;->b(Ljava/lang/String;Lorg/json/JSONObject;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "Error occured while dispatching state change."

    invoke-static {v1, v0}, Lacb;->b(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
