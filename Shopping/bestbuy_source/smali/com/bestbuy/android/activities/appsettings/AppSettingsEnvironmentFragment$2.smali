.class Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lmt;

.field final synthetic b:I

.field final synthetic c:Landroid/view/View;

.field final synthetic d:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;Lmt;ILandroid/view/View;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->d:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->a:Lmt;

    iput p3, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->b:I

    iput-object p4, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 7

    .prologue
    const v6, 0x7f0c00ae

    const v5, 0x7f0c00ad

    const/4 v4, 0x0

    const/16 v3, 0x8

    .line 146
    if-eqz p2, :cond_0

    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->d:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->c(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 148
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->a:Lmt;

    invoke-virtual {v1}, Lmt;->a()Ljava/lang/String;

    move-result-object v1

    iget v2, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->b:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 149
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->a:Lmt;

    invoke-virtual {v0}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v0

    iget v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->b:I

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 151
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->a:Lmt;

    invoke-virtual {v1}, Lmt;->a()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Offers"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 152
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->d:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    invoke-static {v1, v4}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;I)I

    .line 153
    const-string v1, "Custom"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 155
    invoke-static {}, Lgm;->a()Lgn;

    move-result-object v1

    .line 156
    sget-object v0, Lgn;->c:Lgn;

    invoke-virtual {v1, v0}, Lgn;->compareTo(Ljava/lang/Enum;)I

    move-result v0

    if-nez v0, :cond_0

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iget-object v2, v1, Lgn;->e:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iget-object v1, v1, Lgn;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 223
    :cond_0
    :goto_0
    return-void

    .line 161
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 162
    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lgm;->a(Lft;)V

    goto :goto_0

    .line 164
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->a:Lmt;

    invoke-virtual {v1}, Lmt;->a()Ljava/lang/String;

    move-result-object v1

    const-string v2, "CartManager"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 165
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->d:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    const/16 v2, 0xa

    invoke-static {v1, v2}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;I)I

    .line 166
    const-string v1, "Custom"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 168
    invoke-static {}, Lga;->a()Lgb;

    move-result-object v1

    .line 169
    sget-object v0, Lgb;->f:Lgb;

    invoke-virtual {v1, v0}, Lgb;->compareTo(Ljava/lang/Enum;)I

    move-result v0

    if-nez v0, :cond_0

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iget-object v1, v1, Lgb;->g:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 173
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 174
    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lga;->a(Lft;)V

    goto :goto_0

    .line 176
    :cond_4
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->a:Lmt;

    invoke-virtual {v1}, Lmt;->a()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Deals"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 177
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->d:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;I)I

    .line 178
    const-string v1, "Custom"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 179
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 180
    invoke-static {}, Lgd;->a()Lge;

    move-result-object v1

    .line 181
    sget-object v0, Lge;->c:Lge;

    invoke-virtual {v1, v0}, Lge;->compareTo(Ljava/lang/Enum;)I

    move-result v0

    if-nez v0, :cond_0

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iget-object v2, v1, Lge;->e:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iget-object v1, v1, Lge;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 186
    :cond_5
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 187
    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lgd;->a(Lft;)V

    goto/16 :goto_0

    .line 189
    :cond_6
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->a:Lmt;

    invoke-virtual {v1}, Lmt;->a()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Experience Platform"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 190
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->d:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    const/4 v2, 0x2

    invoke-static {v1, v2}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;I)I

    .line 191
    const-string v1, "Custom"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 193
    invoke-static {}, Lgg;->a()Lgh;

    move-result-object v1

    .line 194
    sget-object v0, Lgh;->e:Lgh;

    invoke-virtual {v1, v0}, Lgh;->compareTo(Ljava/lang/Enum;)I

    move-result v0

    if-nez v0, :cond_0

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iget-object v2, v1, Lgh;->g:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iget-object v1, v1, Lgh;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 199
    :cond_7
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 200
    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lgg;->a(Lft;)V

    goto/16 :goto_0

    .line 202
    :cond_8
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->a:Lmt;

    invoke-virtual {v1}, Lmt;->a()Ljava/lang/String;

    move-result-object v1

    const-string v2, "SI"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 203
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->d:Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;

    const/16 v2, 0xb

    invoke-static {v1, v2}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;I)I

    .line 204
    const-string v1, "Custom"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 206
    invoke-static {}, Lgq;->a()Lgr;

    move-result-object v1

    .line 207
    sget-object v0, Lgr;->e:Lgr;

    invoke-virtual {v1, v0}, Lgr;->compareTo(Ljava/lang/Enum;)I

    move-result v0

    if-nez v0, :cond_0

    .line 208
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iget-object v1, v1, Lgr;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 211
    :cond_9
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 212
    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lgq;->a(Lft;)V

    goto/16 :goto_0

    .line 215
    :cond_a
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->a:Lmt;

    invoke-virtual {v1}, Lmt;->a()Ljava/lang/String;

    move-result-object v1

    const-string v2, "CIA"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 216
    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lna;->a(Lft;)V

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 218
    :cond_b
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->a:Lmt;

    invoke-virtual {v1}, Lmt;->a()Ljava/lang/String;

    move-result-object v1

    const-string v2, "SmallViewCart"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 219
    invoke-static {v0}, Lfs;->a(Ljava/lang/String;)Lft;

    move-result-object v0

    invoke-static {v0}, Lna;->b(Lft;)V

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;->c:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0
.end method
