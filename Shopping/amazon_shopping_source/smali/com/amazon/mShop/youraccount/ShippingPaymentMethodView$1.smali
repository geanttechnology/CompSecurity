.class Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$1;
.super Landroid/widget/ArrayAdapter;
.source "ShippingPaymentMethodView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;Ljava/util/List;Lcom/amazon/mShop/control/account/OneClickController;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Landroid/view/View;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;

.field final synthetic val$viewsArray:[Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;Landroid/content/Context;I[Landroid/view/View;[Landroid/view/View;)V
    .locals 0
    .param p2, "x0"    # Landroid/content/Context;
    .param p3, "x1"    # I
    .param p4, "x2"    # [Landroid/view/View;

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$1;->this$0:Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;

    iput-object p5, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$1;->val$viewsArray:[Landroid/view/View;

    invoke-direct {p0, p2, p3, p4}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$1;->val$viewsArray:[Landroid/view/View;

    aget-object v0, v0, p1

    return-object v0
.end method
