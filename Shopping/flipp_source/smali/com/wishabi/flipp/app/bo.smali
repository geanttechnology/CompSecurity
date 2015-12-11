.class public Lcom/wishabi/flipp/app/bo;
.super Landroid/app/Fragment;
.source "SourceFile"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/Fragment;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# static fields
.field private static final l:Ljava/lang/String;


# instance fields
.field private final A:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/wishabi/flipp/app/bv;",
            ">;"
        }
    .end annotation
.end field

.field a:Lcom/wishabi/flipp/app/bu;

.field b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

.field c:Landroid/graphics/RectF;

.field d:Z

.field e:I

.field f:Lcom/wishabi/flipp/content/Flyer$Model;

.field g:Z

.field final h:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lcom/wishabi/flipp/widget/bi;",
            ">;"
        }
    .end annotation
.end field

.field final i:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wishabi/flipp/widget/bi;",
            ">;"
        }
    .end annotation
.end field

.field final j:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field k:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/wishabi/flipp/widget/bi;",
            ">;"
        }
    .end annotation
.end field

.field private m:Landroid/widget/Toast;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:Z

.field private q:Ljava/lang/String;

.field private r:Ljava/lang/String;

.field private s:Z

.field private t:Z

.field private u:Z

.field private v:Z

.field private w:Z

.field private x:Z

.field private y:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/content/c;",
            ">;>;"
        }
    .end annotation
.end field

.field private final z:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 86
    const-class v0, Lcom/wishabi/flipp/app/bo;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/app/bo;->l:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x1

    .line 62
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 114
    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->v:Z

    .line 115
    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->w:Z

    .line 116
    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->x:Z

    .line 119
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    .line 123
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->i:Ljava/util/List;

    .line 129
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->j:Ljava/util/HashSet;

    .line 132
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->z:Ljava/util/HashSet;

    .line 134
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->A:Ljava/util/HashMap;

    .line 137
    new-instance v0, Lcom/wishabi/flipp/app/bp;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/bp;-><init>(Lcom/wishabi/flipp/app/bo;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->k:Ljava/util/Comparator;

    .line 189
    return-void
.end method

.method private static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 5

    .prologue
    .line 1207
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 1208
    const-string v1, "__FLIPP_POSTAL_CODE__"

    const-string v2, "NULL"

    invoke-static {v2}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 1209
    const-string v2, "__FLIPP_SID__"

    const-string v3, "advertising_id"

    const-string v4, "NULL"

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 1210
    const-string v2, "__FLIPP_PUSH_TOKEN__"

    const-string v3, "gcm_registration_id"

    const-string v4, "NULL"

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 1212
    const-string v1, "__FLIPP_LOCALE__"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 1213
    return-object v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/bo;Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->a:Lcom/wishabi/flipp/app/bu;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->a:Lcom/wishabi/flipp/app/bu;

    invoke-interface {v0, p1}, Lcom/wishabi/flipp/app/bu;->a(Ljava/lang/String;)Z

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->m:Landroid/widget/Toast;

    if-nez v1, :cond_2

    new-instance v1, Landroid/widget/Toast;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/Toast;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/wishabi/flipp/app/bo;->m:Landroid/widget/Toast;

    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->m:Landroid/widget/Toast;

    const/16 v2, 0x50

    const/4 v3, 0x1

    const/high16 v4, 0x425c0000    # 55.0f

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    invoke-static {v3, v4, v5}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v3

    float-to-int v3, v3

    invoke-virtual {v1, v2, v6, v3}, Landroid/widget/Toast;->setGravity(III)V

    invoke-virtual {v0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f03002e

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->m:Landroid/widget/Toast;

    invoke-virtual {v1, v0}, Landroid/widget/Toast;->setView(Landroid/view/View;)V

    :cond_2
    if-nez p1, :cond_3

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->m:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->cancel()V

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->m:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0b00c2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->m:Landroid/widget/Toast;

    invoke-virtual {v0, v6}, Landroid/widget/Toast;->setDuration(I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->m:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/bo;)Z
    .locals 1

    .prologue
    .line 62
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->v:Z

    return v0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/bo;J)Z
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;)[I

    move-result-object v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v2

    sget-object v3, Lcom/wishabi/flipp/b/p;->a:Lcom/wishabi/flipp/b/p;

    invoke-static {v2, v0, v1, v3}, Lcom/wishabi/flipp/app/dr;->a(Landroid/app/Activity;[IZLcom/wishabi/flipp/b/p;)I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 62
    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v2, p1, Lcom/wishabi/flipp/app/bt;->q:Ljava/lang/String;

    invoke-static {v2}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-static {}, Lcom/wishabi/flipp/util/g;->c()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v0, p1, Lcom/wishabi/flipp/app/bt;->q:Ljava/lang/String;

    invoke-static {v0}, Landroid/webkit/MimeTypeMap;->getFileExtensionFromUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_4

    const-string v2, "mp4"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string v2, "3gp"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_2
    iget-object v0, p1, Lcom/wishabi/flipp/app/bt;->g:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    const v0, 0x7f0e00d3

    invoke-virtual {v1, v0}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_1
    iget-object v2, p1, Lcom/wishabi/flipp/app/bt;->q:Ljava/lang/String;

    invoke-static {v0, v2}, Lcom/wishabi/flipp/app/WebVideoActivity;->a(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    :goto_2
    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    const v0, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-wide v2, p1, Lcom/wishabi/flipp/app/bt;->a:J

    sget-object v4, Lcom/wishabi/flipp/b/o;->l:Lcom/wishabi/flipp/b/o;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;)V

    const/4 v0, 0x1

    goto :goto_0

    :cond_3
    iget-object v0, p1, Lcom/wishabi/flipp/app/bt;->g:Ljava/lang/String;

    goto :goto_1

    :cond_4
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iget-object v2, p1, Lcom/wishabi/flipp/app/bt;->q:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    goto :goto_2
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/widget/bi;)Z
    .locals 8

    .prologue
    const/4 v1, 0x0

    .line 62
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    if-eqz v0, :cond_0

    if-eqz v2, :cond_0

    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return v1

    :cond_1
    iget-object v0, p1, Lcom/wishabi/flipp/widget/bi;->c:Ljava/lang/Object;

    check-cast v0, Lcom/wishabi/flipp/app/bt;

    iget-object v2, p1, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v2, v2, Landroid/graphics/RectF;->bottom:F

    iget-object v3, p1, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v3, v3, Landroid/graphics/RectF;->top:F

    sub-float/2addr v2, v3

    iget-object v3, p1, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v3, v3, Landroid/graphics/RectF;->right:F

    iget-object v4, p1, Lcom/wishabi/flipp/widget/bi;->a:Landroid/graphics/RectF;

    iget v4, v4, Landroid/graphics/RectF;->left:F

    sub-float/2addr v3, v4

    div-float/2addr v2, v3

    iget-object v3, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v3, v3, Lcom/wishabi/flipp/content/Flyer$Model;->l:Ljava/lang/String;

    iget-object v4, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v4, v4, Lcom/wishabi/flipp/content/Flyer$Model;->m:Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v4

    iget-wide v6, v0, Lcom/wishabi/flipp/app/bt;->a:J

    if-nez v4, :cond_3

    move v0, v1

    :goto_1
    sget v2, Lcom/wishabi/flipp/app/ds;->a:I

    if-ne v0, v2, :cond_2

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v2, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v3, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v3, v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setHighlightAnnotations(Ljava/util/List;)V

    :cond_2
    if-eqz v0, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_3
    invoke-virtual {v4}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    const/4 v5, 0x3

    invoke-virtual {v0, v5}, Landroid/content/res/Configuration;->isLayoutSizeAtLeast(I)Z

    move-result v0

    if-eqz v0, :cond_4

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0x11

    if-lt v0, v5, :cond_4

    invoke-static {v6, v7, v2}, Lcom/wishabi/flipp/app/df;->a(JF)Lcom/wishabi/flipp/app/df;

    move-result-object v0

    invoke-virtual {v4}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    const-string v3, "item_details"

    invoke-virtual {v0, v2, v3}, Lcom/wishabi/flipp/app/df;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    sget v0, Lcom/wishabi/flipp/app/ds;->b:I

    goto :goto_1

    :cond_4
    invoke-static {v6, v7, v2, v3}, Lcom/wishabi/flipp/app/ItemDetailsActivity;->a(JFLjava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v4, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    const v0, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v4, v0, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    sget v0, Lcom/wishabi/flipp/app/ds;->a:I

    goto :goto_1
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/bo;)V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/wishabi/flipp/app/bo;->e()V

    return-void
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/bo;J)Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    move v0, v1

    :goto_0
    return v0

    :cond_1
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/c;

    iget-boolean v0, v0, Lcom/wishabi/flipp/content/c;->q:Z

    if-eqz v0, :cond_2

    const/4 v0, 0x1

    goto :goto_0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 62
    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v2, p1, Lcom/wishabi/flipp/app/bt;->p:Ljava/lang/String;

    invoke-static {v2}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p1, Lcom/wishabi/flipp/app/bt;->p:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    const-string v4, "tel:"

    invoke-virtual {v2, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    move v2, v1

    :goto_1
    if-eqz v2, :cond_0

    :cond_2
    iget-object v0, p1, Lcom/wishabi/flipp/app/bt;->p:Ljava/lang/String;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-direct {v2, v4, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {v3, v2}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v2, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-wide v4, p1, Lcom/wishabi/flipp/app/bt;->a:J

    sget-object v3, Lcom/wishabi/flipp/b/o;->b:Lcom/wishabi/flipp/b/o;

    invoke-virtual {v0, v2, v4, v5, v3}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;)V

    move v0, v1

    goto :goto_0

    :cond_3
    move v2, v0

    goto :goto_1
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/app/bu;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->a:Lcom/wishabi/flipp/app/bu;

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 62
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v2

    if-nez v2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v2, p1, Lcom/wishabi/flipp/app/bt;->p:Ljava/lang/String;

    invoke-static {v2}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-static {}, Lcom/wishabi/flipp/util/g;->c()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v0, p1, Lcom/wishabi/flipp/app/bt;->p:Ljava/lang/String;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bo;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/wishabi/flipp/app/fu;->b()Lcom/wishabi/flipp/app/fx;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/wishabi/flipp/app/fx;->a(Ljava/lang/String;)Lcom/wishabi/flipp/app/fx;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/fx;->a()Lcom/wishabi/flipp/app/fx;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/fx;->b()Lcom/wishabi/flipp/app/fx;

    move-result-object v0

    iget-object v2, v0, Lcom/wishabi/flipp/app/fx;->a:Landroid/os/Bundle;

    const-string v3, "enable_javascript"

    invoke-virtual {v2, v3, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    iget-object v0, v0, Lcom/wishabi/flipp/app/fx;->a:Landroid/os/Bundle;

    invoke-static {v0}, Lcom/wishabi/flipp/app/WebViewActivity;->a(Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const v2, 0x7f040001

    const v3, 0x7f040002

    invoke-virtual {v0, v2, v3}, Landroid/app/Activity;->overridePendingTransition(II)V

    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v2, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-wide v4, p1, Lcom/wishabi/flipp/app/bt;->a:J

    sget-object v3, Lcom/wishabi/flipp/b/o;->a:Lcom/wishabi/flipp/b/o;

    invoke-virtual {v0, v2, v4, v5, v3}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;JLcom/wishabi/flipp/b/o;)V

    move v0, v1

    goto :goto_0
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/widget/FlyerViewGroup;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    return-object v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/bo;Lcom/wishabi/flipp/app/bt;)Z
    .locals 8

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 62
    iget-object v0, p1, Lcom/wishabi/flipp/app/bt;->r:Ljava/lang/Integer;

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->A:Ljava/util/HashMap;

    iget-object v3, p1, Lcom/wishabi/flipp/app/bt;->r:Ljava/lang/Integer;

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/bv;

    if-eqz v0, :cond_1

    iget-object v3, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    if-nez v3, :cond_2

    :cond_1
    move v0, v1

    goto :goto_0

    :cond_2
    iget-object v3, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    new-instance v4, Landroid/graphics/RectF;

    iget v5, v0, Lcom/wishabi/flipp/app/bv;->a:F

    iget v6, v0, Lcom/wishabi/flipp/app/bv;->d:F

    iget v7, v0, Lcom/wishabi/flipp/app/bv;->c:F

    iget v0, v0, Lcom/wishabi/flipp/app/bv;->b:F

    invoke-direct {v4, v5, v6, v7, v0}, Landroid/graphics/RectF;-><init>(FFFF)V

    invoke-virtual {v3, v4, v2, v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(Landroid/graphics/RectF;ZZ)V

    move v0, v2

    goto :goto_0
.end method

.method private e()V
    .locals 15

    .prologue
    .line 833
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 933
    :cond_0
    :goto_0
    return-void

    .line 836
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    .line 843
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 847
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->j:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 848
    iget-object v2, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_2

    .line 849
    iget-object v2, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    iget-object v0, v2, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    iget-object v2, v0, Lcom/wishabi/flipp/widget/bn;->e:Ljava/util/HashMap;

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bn;->invalidate()V

    goto :goto_1

    .line 853
    :cond_3
    const/16 v0, 0xb

    new-array v4, v0, [I

    .line 854
    const/4 v0, 0x0

    const v1, 0x7f020056

    aput v1, v4, v0

    .line 855
    const/4 v0, 0x1

    const v1, 0x7f020057

    aput v1, v4, v0

    .line 856
    const/4 v0, 0x2

    const v1, 0x7f020058

    aput v1, v4, v0

    .line 857
    const/4 v0, 0x3

    const v1, 0x7f020059

    aput v1, v4, v0

    .line 858
    const/4 v0, 0x4

    const v1, 0x7f02005a

    aput v1, v4, v0

    .line 859
    const/4 v0, 0x5

    const v1, 0x7f02005b

    aput v1, v4, v0

    .line 860
    const/4 v0, 0x6

    const v1, 0x7f02005c

    aput v1, v4, v0

    .line 861
    const/4 v0, 0x7

    const v1, 0x7f02005d

    aput v1, v4, v0

    .line 862
    const/16 v0, 0x8

    const v1, 0x7f02005e

    aput v1, v4, v0

    .line 863
    const/16 v0, 0x9

    const v1, 0x7f02005f

    aput v1, v4, v0

    .line 864
    const/16 v0, 0xa

    const v1, 0x7f020060

    aput v1, v4, v0

    .line 866
    const/16 v0, 0xb

    new-array v3, v0, [I

    .line 867
    const/4 v0, 0x0

    const v1, 0x7f020061

    aput v1, v3, v0

    .line 868
    const/4 v0, 0x1

    const v1, 0x7f020062

    aput v1, v3, v0

    .line 869
    const/4 v0, 0x2

    const v1, 0x7f020063

    aput v1, v3, v0

    .line 870
    const/4 v0, 0x3

    const v1, 0x7f020064

    aput v1, v3, v0

    .line 871
    const/4 v0, 0x4

    const v1, 0x7f020065

    aput v1, v3, v0

    .line 872
    const/4 v0, 0x5

    const v1, 0x7f020066

    aput v1, v3, v0

    .line 873
    const/4 v0, 0x6

    const v1, 0x7f020067

    aput v1, v3, v0

    .line 874
    const/4 v0, 0x7

    const v1, 0x7f020068

    aput v1, v3, v0

    .line 875
    const/16 v0, 0x8

    const v1, 0x7f020069

    aput v1, v3, v0

    .line 876
    const/16 v0, 0x9

    const v1, 0x7f02006a

    aput v1, v3, v0

    .line 877
    const/16 v0, 0xa

    const v1, 0x7f02006b

    aput v1, v3, v0

    .line 879
    const/4 v0, 0x4

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    neg-int v5, v0

    .line 880
    const/4 v0, 0x4

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v6

    .line 882
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 883
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->j:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    .line 885
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_4
    :goto_2
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_e

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 886
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    .line 888
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/bi;

    .line 889
    if-eqz v0, :cond_4

    .line 890
    iget-object v0, v0, Lcom/wishabi/flipp/widget/bi;->c:Ljava/lang/Object;

    check-cast v0, Lcom/wishabi/flipp/app/bt;

    .line 895
    const/4 v2, 0x0

    .line 896
    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v1, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    .line 897
    if-eqz v1, :cond_6

    .line 898
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_5
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_6

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/content/c;

    .line 899
    iget-boolean v1, v1, Lcom/wishabi/flipp/content/c;->q:Z

    if-eqz v1, :cond_5

    .line 900
    const/4 v1, 0x1

    move v2, v1

    .line 907
    :cond_6
    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iget-object v1, v1, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    iget-object v1, v1, Lcom/wishabi/flipp/widget/bn;->e:Ljava/util/HashMap;

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v1, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/widget/bj;

    new-instance v9, Lcom/wishabi/flipp/widget/bl;

    const/4 v12, 0x0

    invoke-direct {v9, v1, v12}, Lcom/wishabi/flipp/widget/bl;-><init>(Lcom/wishabi/flipp/widget/bj;B)V

    if-eqz v2, :cond_8

    move-object v1, v3

    :goto_3
    invoke-virtual {v9, v1}, Lcom/wishabi/flipp/widget/bl;->a([I)Lcom/wishabi/flipp/widget/bl;

    move-result-object v2

    new-instance v1, Landroid/graphics/PointF;

    iget v9, v0, Lcom/wishabi/flipp/app/bt;->f:F

    iget v12, v0, Lcom/wishabi/flipp/app/bt;->d:F

    invoke-direct {v1, v9, v12}, Landroid/graphics/PointF;-><init>(FF)V

    sget v9, Lcom/wishabi/flipp/widget/bm;->a:I

    iput-object v1, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iput v9, v2, Lcom/wishabi/flipp/widget/bl;->f:I

    const/4 v1, 0x0

    iput-object v1, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    int-to-float v1, v5

    int-to-float v9, v6

    iput v1, v2, Lcom/wishabi/flipp/widget/bl;->d:F

    iput v9, v2, Lcom/wishabi/flipp/widget/bl;->e:F

    iget-object v1, v2, Lcom/wishabi/flipp/widget/bl;->b:Ljava/util/List;

    if-eqz v1, :cond_7

    iget-object v1, v2, Lcom/wishabi/flipp/widget/bl;->b:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_9

    :cond_7
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Drawables cannot be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_8
    move-object v1, v4

    goto :goto_3

    :cond_9
    iget v1, v2, Lcom/wishabi/flipp/widget/bl;->f:I

    if-nez v1, :cond_a

    sget v1, Lcom/wishabi/flipp/widget/bm;->b:I

    iput v1, v2, Lcom/wishabi/flipp/widget/bl;->f:I

    :cond_a
    iget-object v1, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    if-nez v1, :cond_b

    new-instance v1, Landroid/graphics/PointF;

    const/4 v9, 0x0

    const/4 v12, 0x0

    invoke-direct {v1, v9, v12}, Landroid/graphics/PointF;-><init>(FF)V

    iput-object v1, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    :cond_b
    iget-object v1, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    if-eqz v1, :cond_c

    iget-object v1, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    invoke-virtual {v1}, Landroid/graphics/RectF;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_d

    :cond_c
    iget-object v1, v2, Lcom/wishabi/flipp/widget/bl;->b:Ljava/util/List;

    const/4 v9, 0x0

    invoke-interface {v1, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/Drawable;

    new-instance v9, Landroid/graphics/RectF;

    invoke-direct {v9}, Landroid/graphics/RectF;-><init>()V

    iput-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    sget-object v9, Lcom/wishabi/flipp/widget/bk;->a:[I

    iget v12, v2, Lcom/wishabi/flipp/widget/bl;->f:I

    add-int/lit8 v12, v12, -0x1

    aget v9, v9, v12

    packed-switch v9, :pswitch_data_0

    :cond_d
    :goto_4
    new-instance v1, Lcom/wishabi/flipp/widget/bj;

    const/4 v9, 0x0

    invoke-direct {v1, v2, v9}, Lcom/wishabi/flipp/widget/bj;-><init>(Lcom/wishabi/flipp/widget/bl;B)V

    .line 914
    iget-object v2, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iget-object v2, v2, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bn;->e:Ljava/util/HashMap;

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    invoke-virtual {v9, v12, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/bn;->invalidate()V

    .line 915
    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->j:Ljava/util/HashSet;

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 916
    new-instance v1, Lcom/wishabi/flipp/widget/bi;

    iget v2, v0, Lcom/wishabi/flipp/app/bt;->e:F

    iget v9, v0, Lcom/wishabi/flipp/app/bt;->d:F

    iget v10, v0, Lcom/wishabi/flipp/app/bt;->f:F

    iget v0, v0, Lcom/wishabi/flipp/app/bt;->c:F

    invoke-direct {v1, v2, v9, v10, v0}, Lcom/wishabi/flipp/widget/bi;-><init>(FFFF)V

    invoke-interface {v7, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_2

    .line 907
    :pswitch_0
    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v9

    div-int/lit8 v9, v9, 0x2

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v13, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v13, v13, Landroid/graphics/PointF;->x:F

    int-to-float v14, v9

    sub-float/2addr v13, v14

    iput v13, v12, Landroid/graphics/RectF;->left:F

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v13, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v13, v13, Landroid/graphics/PointF;->y:F

    int-to-float v14, v1

    sub-float/2addr v13, v14

    iput v13, v12, Landroid/graphics/RectF;->top:F

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v13, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v13, v13, Landroid/graphics/PointF;->x:F

    int-to-float v9, v9

    add-float/2addr v9, v13

    iput v9, v12, Landroid/graphics/RectF;->right:F

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->y:F

    int-to-float v1, v1

    add-float/2addr v1, v12

    iput v1, v9, Landroid/graphics/RectF;->bottom:F

    goto :goto_4

    :pswitch_1
    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->x:F

    iput v12, v9, Landroid/graphics/RectF;->left:F

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->y:F

    iput v12, v9, Landroid/graphics/RectF;->top:F

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->x:F

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v13

    int-to-float v13, v13

    add-float/2addr v12, v13

    iput v12, v9, Landroid/graphics/RectF;->right:F

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->y:F

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    int-to-float v1, v1

    add-float/2addr v1, v12

    iput v1, v9, Landroid/graphics/RectF;->bottom:F

    goto/16 :goto_4

    :pswitch_2
    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->x:F

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v13

    int-to-float v13, v13

    sub-float/2addr v12, v13

    iput v12, v9, Landroid/graphics/RectF;->left:F

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->y:F

    iput v12, v9, Landroid/graphics/RectF;->top:F

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->x:F

    iput v12, v9, Landroid/graphics/RectF;->right:F

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->y:F

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    int-to-float v1, v1

    add-float/2addr v1, v12

    iput v1, v9, Landroid/graphics/RectF;->bottom:F

    goto/16 :goto_4

    :pswitch_3
    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->x:F

    iput v12, v9, Landroid/graphics/RectF;->left:F

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->y:F

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v13

    int-to-float v13, v13

    sub-float/2addr v12, v13

    iput v12, v9, Landroid/graphics/RectF;->top:F

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->x:F

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    int-to-float v1, v1

    add-float/2addr v1, v12

    iput v1, v9, Landroid/graphics/RectF;->right:F

    iget-object v1, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v9, v9, Landroid/graphics/PointF;->y:F

    iput v9, v1, Landroid/graphics/RectF;->bottom:F

    goto/16 :goto_4

    :pswitch_4
    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->x:F

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v13

    int-to-float v13, v13

    sub-float/2addr v12, v13

    iput v12, v9, Landroid/graphics/RectF;->left:F

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v12, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v12, v12, Landroid/graphics/PointF;->y:F

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    int-to-float v1, v1

    sub-float v1, v12, v1

    iput v1, v9, Landroid/graphics/RectF;->top:F

    iget-object v1, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v9, v9, Landroid/graphics/PointF;->x:F

    iput v9, v1, Landroid/graphics/RectF;->right:F

    iget-object v1, v2, Lcom/wishabi/flipp/widget/bl;->g:Landroid/graphics/RectF;

    iget-object v9, v2, Lcom/wishabi/flipp/widget/bl;->c:Landroid/graphics/PointF;

    iget v9, v9, Landroid/graphics/PointF;->y:F

    iput v9, v1, Landroid/graphics/RectF;->bottom:F

    goto/16 :goto_4

    .line 920
    :cond_e
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->k:Ljava/util/Comparator;

    invoke-static {v7, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 922
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->g:Z

    if-eqz v0, :cond_f

    .line 923
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a()V

    .line 926
    :cond_f
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 927
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->i:Ljava/util/List;

    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 928
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->i:Ljava/util/List;

    invoke-interface {v0, v7}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 929
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->i:Ljava/util/List;

    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->k:Ljava/util/Comparator;

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 932
    invoke-direct {p0}, Lcom/wishabi/flipp/app/bo;->f()V

    goto/16 :goto_0

    .line 907
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method static synthetic e(Lcom/wishabi/flipp/app/bo;)Z
    .locals 1

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->u:Z

    return v0
.end method

.method static synthetic f(Lcom/wishabi/flipp/app/bo;)Lcom/wishabi/flipp/content/Flyer$Model;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    return-object v0
.end method

.method private f()V
    .locals 10

    .prologue
    .line 936
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    if-nez v0, :cond_1

    .line 989
    :cond_0
    return-void

    .line 939
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->b()Z

    move-result v0

    if-nez v0, :cond_0

    .line 942
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    .line 945
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 949
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 950
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->j:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 951
    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/widget/bi;

    .line 952
    if-eqz v1, :cond_2

    .line 953
    iget-object v1, v1, Lcom/wishabi/flipp/widget/bi;->c:Ljava/lang/Object;

    check-cast v1, Lcom/wishabi/flipp/app/bt;

    .line 956
    iget v2, v1, Lcom/wishabi/flipp/app/bt;->o:I

    invoke-static {v2}, Lcom/wishabi/flipp/content/ag;->b(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 957
    iget-object v2, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    .line 960
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_2

    .line 961
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_3
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/content/c;

    .line 964
    iget-boolean v2, v2, Lcom/wishabi/flipp/content/c;->q:Z

    if-eqz v2, :cond_3

    .line 965
    invoke-virtual {v3, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 972
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->z:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_5
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 973
    invoke-virtual {v3, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_5

    .line 974
    iget-object v2, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    iget-object v0, v2, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b:Lcom/wishabi/flipp/widget/bo;

    iget-object v2, v0, Lcom/wishabi/flipp/widget/bo;->c:Ljava/util/HashMap;

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/bo;->invalidate()V

    goto :goto_1

    .line 978
    :cond_6
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->z:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->clear()V

    .line 980
    invoke-virtual {v3}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 981
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    .line 982
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/app/bt;

    .line 984
    iget-object v3, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    new-instance v6, Landroid/graphics/RectF;

    iget v7, v0, Lcom/wishabi/flipp/app/bt;->e:F

    iget v8, v0, Lcom/wishabi/flipp/app/bt;->d:F

    iget v9, v0, Lcom/wishabi/flipp/app/bt;->f:F

    iget v0, v0, Lcom/wishabi/flipp/app/bt;->c:F

    invoke-direct {v6, v7, v8, v9, v0}, Landroid/graphics/RectF;-><init>(FFFF)V

    invoke-virtual {v3, v4, v5, v6}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(JLandroid/graphics/RectF;)V

    .line 987
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->z:Ljava/util/HashSet;

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_2
.end method

.method static synthetic g(Lcom/wishabi/flipp/app/bo;)Z
    .locals 1

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->w:Z

    return v0
.end method

.method static synthetic h(Lcom/wishabi/flipp/app/bo;)Z
    .locals 1

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->s:Z

    return v0
.end method

.method static synthetic i(Lcom/wishabi/flipp/app/bo;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    return-object v0
.end method


# virtual methods
.method public final a()V
    .locals 4

    .prologue
    .line 568
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->u:Z

    .line 570
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    if-eqz v0, :cond_0

    .line 571
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v2, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getVisibleRect()Landroid/graphics/RectF;

    move-result-object v2

    iget-object v3, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v3}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->getZoomScale()F

    move-result v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;Landroid/graphics/RectF;F)V

    .line 575
    :cond_0
    return-void
.end method

.method public final b()Z
    .locals 1

    .prologue
    .line 788
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->w:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->v:Z

    if-nez v0, :cond_1

    :cond_0
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->x:Z

    if-eqz v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final c()V
    .locals 3

    .prologue
    .line 792
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 804
    :cond_0
    :goto_0
    return-void

    .line 795
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->a:Lcom/wishabi/flipp/app/bu;

    if-eqz v0, :cond_0

    .line 802
    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->a:Lcom/wishabi/flipp/app/bu;

    iget-object v2, p0, Lcom/wishabi/flipp/app/bo;->r:Ljava/lang/String;

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->w:Z

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->v:Z

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->x:Z

    if-nez v0, :cond_2

    const/4 v0, 0x1

    :goto_1
    invoke-interface {v1, p0, v2, v0}, Lcom/wishabi/flipp/app/bu;->a(Lcom/wishabi/flipp/app/bo;Ljava/lang/String;Z)V

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public final d()Z
    .locals 1

    .prologue
    .line 815
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v7, 0x0

    const/4 v3, 0x0

    .line 579
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 580
    if-nez v1, :cond_0

    move-object v0, v3

    .line 597
    :goto_0
    return-object v0

    .line 583
    :cond_0
    packed-switch p1, :pswitch_data_0

    move-object v0, v3

    .line 597
    goto :goto_0

    .line 585
    :pswitch_0
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->c:Landroid/net/Uri;

    const-string v4, "flyer_id = ?"

    new-array v5, v5, [Ljava/lang/String;

    iget-object v6, p0, Lcom/wishabi/flipp/app/bo;->r:Ljava/lang/String;

    aput-object v6, v5, v7

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 588
    :pswitch_1
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    const-string v4, "flyer_id = ?"

    new-array v5, v5, [Ljava/lang/String;

    iget-object v6, p0, Lcom/wishabi/flipp/app/bo;->r:Ljava/lang/String;

    aput-object v6, v5, v7

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 591
    :pswitch_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->r:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const-string v2, "flyer_item_coupons.flyer_id = ?"

    new-array v3, v5, [Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v7

    invoke-static {v1, v2, v3, v7}, Lcom/wishabi/flipp/content/l;->a(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Z)Landroid/content/Loader;

    move-result-object v0

    goto :goto_0

    .line 594
    :pswitch_3
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->d:Landroid/net/Uri;

    const-string v4, "flyer_id = ?"

    new-array v5, v5, [Ljava/lang/String;

    iget-object v6, p0, Lcom/wishabi/flipp/app/bo;->r:Ljava/lang/String;

    aput-object v6, v5, v7

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 583
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10

    .prologue
    .line 215
    const v0, 0x7f03002a

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v6

    .line 216
    if-nez v6, :cond_0

    .line 217
    const/4 v0, 0x0

    .line 232
    :goto_0
    return-object v0

    .line 219
    :cond_0
    const v0, 0x7f0b00b2

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    .line 221
    if-eqz p3, :cond_1

    .line 222
    const-string v0, "mInitialRect"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/graphics/RectF;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->c:Landroid/graphics/RectF;

    .line 223
    const-string v0, "mFlyerModel"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/Flyer$Model;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    .line 226
    :cond_1
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getActivity()Landroid/app/Activity;

    move-result-object v5

    if-eqz v5, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->c:Landroid/graphics/RectF;

    if-nez v0, :cond_4

    .line 228
    :cond_2
    :goto_1
    iget-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->u:Z

    if-eqz v0, :cond_3

    .line 229
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->a()V

    :cond_3
    move-object v0, v6

    .line 232
    goto :goto_0

    .line 226
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget v0, v0, Lcom/wishabi/flipp/content/Flyer$Model;->a:I

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->r:Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->v:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->w:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->x:Z

    new-instance v0, Lcom/wishabi/flipp/app/bq;

    invoke-virtual {v5}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    iget-object v4, p0, Lcom/wishabi/flipp/app/bo;->r:Ljava/lang/String;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/wishabi/flipp/app/bq;-><init>(Lcom/wishabi/flipp/app/bo;Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/bq;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v0, v0, Lcom/wishabi/flipp/content/Flyer$Model;->m:Ljava/lang/String;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->q:Ljava/lang/String;

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v0, v0, Lcom/wishabi/flipp/content/Flyer$Model;->g:Ljava/lang/String;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->n:Ljava/lang/String;

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v0, v0, Lcom/wishabi/flipp/content/Flyer$Model;->h:Ljava/lang/String;

    iput-object v0, p0, Lcom/wishabi/flipp/app/bo;->o:Ljava/lang/String;

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-boolean v0, v0, Lcom/wishabi/flipp/content/Flyer$Model;->e:Z

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->p:Z

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v1, v1, Lcom/wishabi/flipp/content/Flyer$Model;->k:Ljava/lang/String;

    iget-object v2, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v2, v2, Lcom/wishabi/flipp/content/Flyer$Model;->q:[F

    iget-object v3, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v3, v3, Lcom/wishabi/flipp/content/Flyer$Model;->i:Ljava/lang/Float;

    invoke-virtual {v3}, Ljava/lang/Float;->intValue()I

    move-result v3

    iget-object v4, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-object v4, v4, Lcom/wishabi/flipp/content/Flyer$Model;->j:Ljava/lang/Float;

    invoke-virtual {v4}, Ljava/lang/Float;->intValue()I

    move-result v4

    iput v3, v0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->e:I

    iput v4, v0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->f:I

    iget-object v7, v0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a:Lcom/wishabi/flipp/widget/dw;

    int-to-float v8, v3

    int-to-float v9, v4

    invoke-virtual {v7, v1, v2, v8, v9}, Lcom/wishabi/flipp/widget/dw;->a(Ljava/lang/String;[FFF)V

    iget-object v0, v0, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    iput v3, v0, Lcom/wishabi/flipp/widget/bn;->c:I

    iput v4, v0, Lcom/wishabi/flipp/widget/bn;->d:I

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    iget-boolean v0, v0, Lcom/wishabi/flipp/content/Flyer$Model;->n:Z

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/bo;->t:Z

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->scrollTo(II)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->c:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->c:Landroid/graphics/RectF;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setInitialRect(Landroid/graphics/RectF;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->c:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->setEmpty()V

    :cond_5
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    new-instance v1, Lcom/wishabi/flipp/app/br;

    invoke-direct {v1, p0, v5}, Lcom/wishabi/flipp/app/br;-><init>(Lcom/wishabi/flipp/app/bo;Landroid/app/Activity;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setFlyerViewListener(Lcom/wishabi/flipp/widget/bt;)V

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/bo;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    if-eqz v0, :cond_2

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    const/4 v1, 0x3

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto/16 :goto_1
.end method

.method public onDestroy()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 237
    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    .line 238
    iget-object v2, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iget-object v3, v2, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a:Lcom/wishabi/flipp/widget/dw;

    iget-object v0, v3, Lcom/wishabi/flipp/widget/dw;->e:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wishabi/flipp/widget/dx;

    iput-object v5, v1, Lcom/wishabi/flipp/widget/dx;->c:Landroid/graphics/Bitmap;

    iget-object v1, v3, Lcom/wishabi/flipp/widget/dw;->c:Lcom/a/b/ad;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/a/b/aw;

    invoke-virtual {v1, v0}, Lcom/a/b/ad;->a(Ljava/lang/Object;)V

    goto :goto_0

    :cond_0
    iget-object v0, v3, Lcom/wishabi/flipp/widget/dw;->d:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/dx;

    iput-object v5, v0, Lcom/wishabi/flipp/widget/dx;->c:Landroid/graphics/Bitmap;

    goto :goto_1

    :cond_1
    iget-object v0, v3, Lcom/wishabi/flipp/widget/dw;->f:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/dx;

    iput-object v5, v0, Lcom/wishabi/flipp/widget/dx;->c:Landroid/graphics/Bitmap;

    goto :goto_2

    :cond_2
    iget-object v0, v3, Lcom/wishabi/flipp/widget/dw;->e:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    iget-object v0, v3, Lcom/wishabi/flipp/widget/dw;->d:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    iget-object v0, v3, Lcom/wishabi/flipp/widget/dw;->f:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->clear()V

    iget-object v0, v2, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b:Lcom/wishabi/flipp/widget/bo;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/bo;->c:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    iget-object v0, v2, Lcom/wishabi/flipp/widget/FlyerViewGroup;->c:Lcom/wishabi/flipp/widget/bv;

    iput-object v5, v0, Lcom/wishabi/flipp/widget/bv;->a:Landroid/graphics/Bitmap;

    iput-object v5, v0, Lcom/wishabi/flipp/widget/bv;->b:Landroid/graphics/Canvas;

    iget-object v0, v2, Lcom/wishabi/flipp/widget/FlyerViewGroup;->d:Lcom/wishabi/flipp/widget/bn;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/bn;->e:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 239
    return-void
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 29

    .prologue
    .line 62
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual/range {p1 .. p1}, Landroid/content/Loader;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    :cond_0
    :goto_0
    return-void

    :pswitch_0
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/wishabi/flipp/app/bo;->s:Z

    const-string v2, "_id"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v13

    const-string v2, "flyer_id"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v14

    const-string v2, "bottom"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v15

    const-string v2, "top"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v16

    const-string v2, "left"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v17

    const-string v2, "right"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v18

    const-string v2, "name"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v19

    const-string v2, "short_name"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v20

    const-string v2, "discount"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v21

    const-string v2, "price"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v22

    const-string v2, "thumbnail"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v23

    const-string v2, "display_type"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v24

    const-string v2, "ttm_url"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v25

    const-string v2, "video_url"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v26

    const-string v2, "page_destination"

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v27

    const/4 v3, 0x1

    const/4 v11, 0x0

    new-instance v28, Ljava/util/ArrayList;

    invoke-direct/range {v28 .. v28}, Ljava/util/ArrayList;-><init>()V

    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    move v4, v3

    move v3, v2

    move v2, v11

    :goto_1
    if-eqz v3, :cond_2

    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput-boolean v3, v0, Lcom/wishabi/flipp/app/bo;->s:Z

    new-instance v9, Lcom/wishabi/flipp/app/bt;

    const/4 v3, 0x0

    invoke-direct {v9, v3}, Lcom/wishabi/flipp/app/bt;-><init>(B)V

    move-object/from16 v0, p2

    invoke-interface {v0, v13}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v6

    iput-wide v6, v9, Lcom/wishabi/flipp/app/bt;->a:J

    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    iput v3, v9, Lcom/wishabi/flipp/app/bt;->b:I

    move-object/from16 v0, p2

    invoke-interface {v0, v15}, Landroid/database/Cursor;->getFloat(I)F

    move-result v3

    iput v3, v9, Lcom/wishabi/flipp/app/bt;->c:F

    move-object/from16 v0, p2

    move/from16 v1, v16

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v3

    iput v3, v9, Lcom/wishabi/flipp/app/bt;->d:F

    move-object/from16 v0, p2

    move/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v3

    iput v3, v9, Lcom/wishabi/flipp/app/bt;->e:F

    move-object/from16 v0, p2

    move/from16 v1, v18

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v3

    iput v3, v9, Lcom/wishabi/flipp/app/bt;->f:F

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/app/bo;->n:Ljava/lang/String;

    iput-object v3, v9, Lcom/wishabi/flipp/app/bt;->g:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/app/bo;->o:Ljava/lang/String;

    iput-object v3, v9, Lcom/wishabi/flipp/app/bt;->h:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-boolean v3, v0, Lcom/wishabi/flipp/app/bo;->p:Z

    iput-boolean v3, v9, Lcom/wishabi/flipp/app/bt;->i:Z

    move-object/from16 v0, p2

    move/from16 v1, v19

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v9, Lcom/wishabi/flipp/app/bt;->j:Ljava/lang/String;

    move-object/from16 v0, p2

    move/from16 v1, v20

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v9, Lcom/wishabi/flipp/app/bt;->k:Ljava/lang/String;

    move-object/from16 v0, p2

    move/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v9, Lcom/wishabi/flipp/app/bt;->l:Ljava/lang/String;

    move-object/from16 v0, p2

    move/from16 v1, v23

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v9, Lcom/wishabi/flipp/app/bt;->m:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/app/bo;->q:Ljava/lang/String;

    iput-object v3, v9, Lcom/wishabi/flipp/app/bt;->n:Ljava/lang/String;

    move-object/from16 v0, p2

    move/from16 v1, v24

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v3

    iput v3, v9, Lcom/wishabi/flipp/app/bt;->o:I

    move-object/from16 v0, p2

    move/from16 v1, v25

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v9, Lcom/wishabi/flipp/app/bt;->p:Ljava/lang/String;

    move-object/from16 v0, p2

    move/from16 v1, v26

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v9, Lcom/wishabi/flipp/app/bt;->q:Ljava/lang/String;

    move-object/from16 v0, p2

    move/from16 v1, v27

    invoke-static {v0, v1}, Lcom/wishabi/flipp/util/f;->c(Landroid/database/Cursor;I)Ljava/lang/Integer;

    move-result-object v3

    iput-object v3, v9, Lcom/wishabi/flipp/app/bt;->r:Ljava/lang/Integer;

    move-object/from16 v0, p2

    move/from16 v1, v21

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v7

    const/4 v3, 0x0

    cmpl-float v3, v7, v3

    if-lez v3, :cond_7

    add-int/lit8 v2, v2, 0x1

    move v11, v2

    :goto_2
    iget-object v2, v9, Lcom/wishabi/flipp/app/bt;->l:Ljava/lang/String;

    if-nez v2, :cond_1

    const/4 v2, 0x1

    :goto_3
    and-int v12, v4, v2

    new-instance v2, Lcom/wishabi/flipp/widget/bi;

    iget v3, v9, Lcom/wishabi/flipp/app/bt;->e:F

    iget v4, v9, Lcom/wishabi/flipp/app/bt;->d:F

    iget v5, v9, Lcom/wishabi/flipp/app/bt;->f:F

    iget v6, v9, Lcom/wishabi/flipp/app/bt;->c:F

    iget-object v8, v9, Lcom/wishabi/flipp/app/bt;->l:Ljava/lang/String;

    const/4 v10, 0x0

    invoke-direct/range {v2 .. v10}, Lcom/wishabi/flipp/widget/bi;-><init>(FFFFFLjava/lang/String;Ljava/lang/Object;I)V

    move-object/from16 v0, v28

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    move v3, v2

    move v4, v12

    move v2, v11

    goto/16 :goto_1

    :cond_1
    const/4 v2, 0x0

    goto :goto_3

    :cond_2
    move-object/from16 v0, p0

    iput-boolean v4, v0, Lcom/wishabi/flipp/app/bo;->d:Z

    move-object/from16 v0, p0

    iput v2, v0, Lcom/wishabi/flipp/app/bo;->e:I

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/app/bo;->k:Ljava/util/Comparator;

    move-object/from16 v0, v28

    invoke-static {v0, v2}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    move-object/from16 v0, v28

    invoke-virtual {v2, v0}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setTapAnnotations(Ljava/util/List;)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->clear()V

    invoke-interface/range {v28 .. v28}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_4
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wishabi/flipp/widget/bi;

    iget-object v3, v2, Lcom/wishabi/flipp/widget/bi;->c:Ljava/lang/Object;

    check-cast v3, Lcom/wishabi/flipp/app/bt;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    iget-wide v6, v3, Lcom/wishabi/flipp/app/bt;->a:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v5, v3, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_4

    :cond_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_4

    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/wishabi/flipp/app/bo;->w:Z

    :cond_4
    invoke-direct/range {p0 .. p0}, Lcom/wishabi/flipp/app/bo;->e()V

    invoke-virtual/range {p0 .. p0}, Lcom/wishabi/flipp/app/bo;->c()V

    goto/16 :goto_0

    :pswitch_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    iget-object v2, v2, Lcom/wishabi/flipp/widget/FlyerViewGroup;->b:Lcom/wishabi/flipp/widget/bo;

    iget-object v3, v2, Lcom/wishabi/flipp/widget/bo;->c:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->clear()V

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/bo;->invalidate()V

    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    :goto_5
    if-eqz v2, :cond_6

    new-instance v2, Landroid/graphics/RectF;

    invoke-direct {v2}, Landroid/graphics/RectF;-><init>()V

    const-string v3, "left"

    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getFloat(I)F

    move-result v3

    iput v3, v2, Landroid/graphics/RectF;->left:F

    const-string v3, "top"

    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getFloat(I)F

    move-result v3

    iput v3, v2, Landroid/graphics/RectF;->top:F

    const-string v3, "right"

    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getFloat(I)F

    move-result v3

    iput v3, v2, Landroid/graphics/RectF;->right:F

    const-string v3, "bottom"

    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getFloat(I)F

    move-result v3

    iput v3, v2, Landroid/graphics/RectF;->bottom:F

    const-string v3, "_id"

    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    move-object/from16 v0, p2

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v3, v4, v5, v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->a(JLandroid/graphics/RectF;)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/app/bo;->z:Ljava/util/HashSet;

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/app/bo;->z:Ljava/util/HashSet;

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    :cond_5
    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    goto :goto_5

    :cond_6
    invoke-direct/range {p0 .. p0}, Lcom/wishabi/flipp/app/bo;->f()V

    goto/16 :goto_0

    :pswitch_2
    invoke-static/range {p2 .. p2}, Lcom/wishabi/flipp/content/l;->a(Landroid/database/Cursor;)Ljava/util/HashMap;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/wishabi/flipp/app/bo;->x:Z

    invoke-direct/range {p0 .. p0}, Lcom/wishabi/flipp/app/bo;->e()V

    invoke-virtual/range {p0 .. p0}, Lcom/wishabi/flipp/app/bo;->c()V

    goto/16 :goto_0

    :pswitch_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/wishabi/flipp/app/bo;->A:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->clear()V

    new-instance v3, Lcom/wishabi/flipp/app/bw;

    const/4 v2, 0x0

    move-object/from16 v0, p2

    invoke-direct {v3, v0, v2}, Lcom/wishabi/flipp/app/bw;-><init>(Landroid/database/Cursor;B)V

    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    :goto_6
    if-eqz v2, :cond_0

    new-instance v2, Lcom/wishabi/flipp/app/bv;

    move-object/from16 v0, p2

    invoke-direct {v2, v3, v0}, Lcom/wishabi/flipp/app/bv;-><init>(Lcom/wishabi/flipp/app/bw;Landroid/database/Cursor;)V

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/wishabi/flipp/app/bo;->A:Ljava/util/HashMap;

    iget v5, v2, Lcom/wishabi/flipp/app/bv;->e:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-interface/range {p2 .. p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    goto :goto_6

    :cond_7
    move v11, v2

    goto/16 :goto_2

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 727
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 745
    :goto_0
    :pswitch_0
    return-void

    .line 729
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->b:Lcom/wishabi/flipp/widget/FlyerViewGroup;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/FlyerViewGroup;->setTapAnnotations(Ljava/util/List;)V

    .line 730
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/bo;->w:Z

    .line 731
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 732
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0

    .line 737
    :pswitch_2
    iput-boolean v1, p0, Lcom/wishabi/flipp/app/bo;->x:Z

    .line 738
    iput-object v2, p0, Lcom/wishabi/flipp/app/bo;->y:Ljava/util/HashMap;

    .line 739
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->i:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0

    .line 742
    :pswitch_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/bo;->A:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    goto :goto_0

    .line 727
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 243
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 244
    const-string v0, "mInitialRect"

    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->c:Landroid/graphics/RectF;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 245
    const-string v0, "mFlyerModel"

    iget-object v1, p0, Lcom/wishabi/flipp/app/bo;->f:Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 246
    return-void
.end method
