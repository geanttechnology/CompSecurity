.class public final Lcom/wishabi/flipp/content/i;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final a:Landroid/net/Uri;

.field public static final b:Landroid/net/Uri;

.field public static final c:Landroid/net/Uri;

.field public static final d:Landroid/net/Uri;

.field public static final e:Landroid/net/Uri;

.field public static final f:Landroid/net/Uri;

.field public static final g:Landroid/net/Uri;

.field public static final h:Landroid/net/Uri;

.field public static final i:Landroid/net/Uri;

.field public static final j:Landroid/net/Uri;

.field public static final k:Landroid/net/Uri;

.field public static final l:Landroid/net/Uri;

.field public static final m:Landroid/net/Uri;

.field public static final n:Landroid/net/Uri;

.field public static final o:Landroid/net/Uri;

.field public static final p:Landroid/net/Uri;

.field public static final q:Landroid/net/Uri;

.field public static final r:Landroid/net/Uri;

.field public static final s:Landroid/net/Uri;

.field public static final t:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-string v0, "content://com.wishabi.flipp.content.Flyer/flyers"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->a:Landroid/net/Uri;

    .line 25
    const-string v0, "content://com.wishabi.flipp.content.Flyer/categories"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->b:Landroid/net/Uri;

    .line 27
    const-string v0, "content://com.wishabi.flipp.content.Flyer/items"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->c:Landroid/net/Uri;

    .line 29
    const-string v0, "content://com.wishabi.flipp.content.Flyer/flyer_pages"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->d:Landroid/net/Uri;

    .line 31
    const-string v0, "content://com.wishabi.flipp.content.Flyer/featured_items"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->e:Landroid/net/Uri;

    .line 34
    const-string v0, "content://com.wishabi.flipp.models.User/favorite_merchants"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->f:Landroid/net/Uri;

    .line 36
    const-string v0, "content://com.wishabi.flipp.models.User/clippings"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    .line 38
    const-string v0, "content://com.wishabi.flipp.models.User/read_flyers"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->h:Landroid/net/Uri;

    .line 40
    const-string v0, "content://com.wishabi.flipp.models.User/sent_analytics"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->i:Landroid/net/Uri;

    .line 44
    const-string v0, "content://com.wishabi.flipp.models.User/shopping_lists"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->j:Landroid/net/Uri;

    .line 46
    const-string v0, "content://com.wishabi.flipp.models.User/shopping_list_items"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->k:Landroid/net/Uri;

    .line 48
    const-string v0, "content://com.wishabi.flipp.models.User/shopping_list_items/categories"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->l:Landroid/net/Uri;

    .line 51
    const-string v0, "content://com.wishabi.flipp.models.User/shopping_list_items/cat_order"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->m:Landroid/net/Uri;

    .line 56
    const-string v0, "content://com.wishabi.flipp.content.Flyer/coupons"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->n:Landroid/net/Uri;

    .line 58
    const-string v0, "content://com.wishabi.flipp.content.Flyer/coupon_categories"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->o:Landroid/net/Uri;

    .line 60
    const-string v0, "content://com.wishabi.flipp.content.Flyer/flyer_item_coupons"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->p:Landroid/net/Uri;

    .line 63
    const-string v0, "content://com.wishabi.flipp.models.User/coupons_query"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->q:Landroid/net/Uri;

    .line 65
    const-string v0, "content://com.wishabi.flipp.models.User/coupons_for_items"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->r:Landroid/net/Uri;

    .line 67
    const-string v0, "content://com.wishabi.flipp.models.User/items_for_coupons"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->s:Landroid/net/Uri;

    .line 69
    const-string v0, "content://com.wishabi.flipp.models.User/user_coupon_data"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/content/i;->t:Landroid/net/Uri;

    return-void
.end method
